package router;

import albert.Client;
import router.action.Action;
import router.exceptions.PageNotFoundException;
import router.factories.RouteFactoryBuilder;
import router.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Router.
 *
 */
/*
De klas Router handelt alle requests van de gebruiker af en geeft responses terug.
 */
public class Router {

    /** The client. */
    private Client client;
    
    /** The history. */
    private ArrayList<String> history = new ArrayList<>();
    
    /** The routes. */
    private HashMap<Route, Action> routes = (new RouteFactoryBuilder()).routes();

    /** The history index. */
    private int historyIndex = 0;

    /**
     * Instantiates a new router.
     *
     * @param client the client
     */
    public Router(Client client) {
        this.client = client;
    }

    /**
     * Gets the client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Adds the route.
     *
     * @param route the route
     * @param action the action
     */
    public void addRoute(Route route, Action action) {
        this.routes.put(route, action);
    }

    /**
     * Navigate.
     *
     * @param url the url
     * @return the response
     */
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

    /**
     * Nav.
     *
     * @param url the url
     */
    public void nav(String url) {
        this.nav(url, true);
    }

    /**
     * Nav.
     *
     * @param url the url
     * @param history the history
     */
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

    /**
     * Adds the to history.
     *
     * @param url the url
     */
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

    /**
     * Checks for items.
     *
     * @return true, if successful
     */
    public boolean hasItems() {
        return this.history.size() > 0;
    }

    /**
     * Checks for previous.
     *
     * @return true, if successful
     */
    public boolean hasPrevious() {
        return this.hasItems() && this.historyIndex > 0;
    }

    /**
     * Checks for next.
     *
     * @return true, if successful
     */
    public boolean hasNext() {
        return this.hasItems() && this.historyIndex < this.history.size() - 1;
    }

    /**
     * Nav to previous.
     */
    public void navToPrevious() {
        // Get previous history
        String route = this.history.get(--this.historyIndex);

        // Route to the new history
        this.nav(route, false);

    }

    /**
     * Nav to next.
     */
    public void navToNext() {
        // Get next history
        String route = this.history.get(++this.historyIndex);

        // Route to the new history
        this.nav(route, false);

    }
}
