package router;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Route {

    private String route;
    private String pattern;
    private ArrayList<String> args;

    public Route(String route) {
        this.setRoute(route);
    }

    public void setRoute(String route) {
        this.pattern = this.generatePattern(route);
    }

    private String generatePattern(String route) {
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

    public boolean match(String route) {
        return route.matches(this.pattern);
    }

    public Request generateRequest(String route) {
        Request request = new Request();

        request.setRoute(route);
        request.setParameters(this.extractParams(route));

        return request;
    }

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

}
