package router;

import router.util.Helper;

import java.util.HashMap;

public class Request {

    private String route;
    private HashMap<String, String> parameters;


    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public HashMap<String, String> getParameters() {
        return this.parameters;
    }

    public String getParameter(String key) {
        return this.parameters.get(key);
    }

    public <T> T getParameter(String key, Class<T> clazz) {
        String value = this.getParameter(key);

        return (value == null) ? Helper.zero(clazz) : Helper.parse(value, clazz);
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}
