package router;

import albert.Client;
import router.action.Action;
import router.factories.RouteFactoryBuilder;
import router.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class Router {

    private Client client;
    private ArrayList<String> history = new ArrayList<>();
    private HashMap<Route, Action> routes = (new RouteFactoryBuilder()).create();

    public Router(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void addRoute(Route route, Action action) {
        this.routes.put(route, action);
    }

    public Response navigate(String url) {

        for (Route route : this.routes.keySet()) {
            if (route.match(url)) {
                Request request = route.generateRequest(url);

                Action action = routes.get(route);

                // Fetch the response from the action
                Response response = action.execute(this, request);

                // Return early, we've found our match and executed it
                return response;
            }
        }

        return null;
    }

    public void nav(String url) {

        // Fetch response
        Response response = this.navigate(url);

        if (response == null) {
            // TODO: Throw 404 exception and show 404
            return;
        }

        response.execute(this);
    }
}
