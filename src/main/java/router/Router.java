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

    private int historyIndex = 0;

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
        this.nav(url, true);
    }

    public void nav(String url, boolean history) {

        System.out.println("url = " + url);

        Response response;

        if (history)
            this.addToHistory(url);

        try {
            // Fetch response
            response = this.navigate(url);
        } catch (PageNotFoundException ex) {
            // Fetch 404 page
            response = this.navigate("errors/404");
        }

        response.execute(this);

    }

    private void addToHistory(String url) {

        // Delete left over history, this is not needed anymore
        if (this.historyIndex < this.history.size() - 1) {

            // Delete the history back to front
            for (int i = this.history.size() - 1; i > this.historyIndex; i--) {
                this.history.remove(i);
            }
        }

        this.history.add(url);
        this.historyIndex = this.history.size() - 1;
    }

    public boolean hasItems() {
        return this.history.size() > 0;
    }

    public boolean hasPrevious() {
        return this.hasItems() && this.historyIndex > 0;
    }

    public boolean hasNext() {
        return this.hasItems() && this.historyIndex < this.history.size() - 1;
    }

    public void navToPrevious() {
        // Get previous history
        String route = this.history.get(--this.historyIndex);

        // Route to the new history
        this.nav(route, false);

    }

    public void navToNext() {
        // Get next history
        String route = this.history.get(++this.historyIndex);

        // Route to the new history
        this.nav(route, false);

    }
}
