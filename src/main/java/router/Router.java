package router;

import albert.Client;
import router.action.Action;
import router.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class Router {

    private Client client;
    private ArrayList<String> history = new ArrayList<>();
    private HashMap<Route, Action> routes = new HashMap<>();

    public Router(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void addRoute(Route route, Action action) {
        this.routes.put(route, action);
    }

    public void navigate(String url) {

        for (Route route : this.routes.keySet()) {

            if (route.match(url)) {
                Request request = route.generateRequest(url);

                Action action = routes.get(route);

                // Fetch the response from the action
                Response response = action.execute(this, request);

                // Execute the response
                response.execute(this);

                // Return early, we've found our match and executed it
                return;
            }

        }

    }
}
