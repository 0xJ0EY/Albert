package router;

import router.util.Helper;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Request.
 * @author
 */
public class Request {

    /** The route. */
    private String route;
    
    /** The parameters. */
    private HashMap<String, String> parameters;


    /**
     * Gets the route.
     *
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * Sets the route.
     *
     * @param route the new route
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * Gets the parameters.
     *
     * @return the parameters
     */
    public HashMap<String, String> getParameters() {
        return this.parameters;
    }

    /**
     * Gets the parameter.
     *
     * @param key the key
     * @return the parameter
     */
    public String getParameter(String key) {
        return this.parameters.get(key);
    }

    /**
     * Gets the parameter.
     *
     * @param <T> the generic type
     * @param key the key
     * @param clazz the clazz
     * @return the parameter
     */
    public <T> T getParameter(String key, Class<T> clazz) {
        String value = this.getParameter(key);

        return (value == null) ? Helper.zero(clazz) : Helper.parse(value, clazz);
    }

    /**
     * Sets the parameters.
     *
     * @param parameters the parameters
     */
    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}
