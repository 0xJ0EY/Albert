package router;

import albert.Client;
import router.action.Action;
import router.exceptions.PageNotFoundException;
import router.factories.RouteFactoryBuilder;
import router.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class Router {

    private Client client;
    private ArrayList<String> history = new ArrayList<>();
    private HashMap<Route, Action> routes = (new RouteFactoryBuilder()).routes();

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

        throw new PageNotFoundException();
    }

    public void nav(String url) {

        Response response;

        try {
            // Fetch response
            response = this.navigate(url);
        } catch (PageNotFoundException ex) {
            // Fetch 404 page
            response = this.navigate("errors/404");
        }

        response.execute(this);
    }
}
