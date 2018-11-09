package router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class Route.
 *
 */
public class Route {

    /** The route. */
    private String route;
    
    /** The pattern. */
    private String pattern;
    
    /** The args. */
    private ArrayList<String> args;

    /**
     * Instantiates a new route.
     *
     * @param route the route
     */
    public Route(String route) {
        this.setRoute(route);
    }

    /**
     * Sets the route.
     *
     * @param route the new route
     */
    public void setRoute(String route) {
        this.pattern = this.generatePattern(route);
    }

    /**
     * Generate pattern.
     *
     * @param route the route
     * @return the string
     */
    private String generatePattern(String route) {

        route = this.trimRoute(route);

        this.args = new ArrayList<>();
        this.route = route;

        // Replace the / with \/ for the pattern
        String regex = route.replaceAll("\\/", "\\\\/");

        // Find all variable names with regex
        String pattern = "\\{([^}]+)\\}";
        Pattern media = Pattern.compile(pattern);
        Matcher matcher = media.matcher(regex);

        // Add all variable names in the array for later
        while (matcher.find()) {
            String match = matcher.group();
            this.args.add(match.replaceAll("[{}]", ""));
        }

        // Replace the old variable with regex group filters
        return regex.replaceAll(pattern, "([^\\\\/]+)");
    }

    /**
     * Builds the url.
     *
     * @param values the values
     * @return the string
     */
    public String buildUrl(HashMap<String, Object> values) {
        String URL = this.route;

        for (int i = 0; i < this.args.size(); i++) {

            String arg = this.args.get(i);

            String pattern = "\\{" + arg + "\\}";

            // Replace the URL, with the updated version
            URL = URL.replaceAll(pattern, values.get(arg).toString());
        }

        return URL;
    }

    /**
     * Match.
     *
     * @param route the route
     * @return true, if successful
     */
    public boolean match(String route) {

        route = this.trimRoute(route);

        return route.matches(this.pattern);
    }

    /**
     * Generate request.
     *
     * @param route the route
     * @return the request
     */
    public Request generateRequest(String route) {
        route = this.trimRoute(route);

        Request request = new Request();

        request.setRoute(route);
        request.setParameters(this.extractParams(route));

        return request;
    }

    /**
     * Extract params.
     *
     * @param route the route
     * @return the hash map
     */
    private HashMap<String, String> extractParams(String route) {
        HashMap<String, String> map = new HashMap<>();

        Pattern media = Pattern.compile(this.pattern);
        Matcher matcher = media.matcher(route);

        // If no match is found, just return the empty HashMap
        if ( ! matcher.find())
            return map;

        for (int i = 0; i < this.args.size(); i++) {

            // Offset by 1 because the 0 key is the full match
            String match = matcher.group(1 + i);

            // Put the record in the HashMap
            map.put(this.args.get(i), match);
        }

        return map;
    }

    /**
     * Trim route.
     *
     * @param route the route
     * @return the string
     */
    private String trimRoute(String route) {
        if (route.length() <= 1) return route;
        return route.replaceAll("/*$", "");
    }

    /**
     * Gets the args.
     *
     * @return the args
     */
    public ArrayList<String> getArgs() {
        return this.args;
    }

}
