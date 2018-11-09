package router.response;

import router.Router;

// TODO: Auto-generated Javadoc
/**
 * The Class RedirectResponse.
 *
 */
public class RedirectResponse implements Response {

    /** The url. */
    private String url;

    /**
     * Instantiates a new redirect response.
     *
     * @param url the url
     */
    public RedirectResponse(String url) {
        this.url = url;
    }

    /* (non-Javadoc)
     * @see router.response.Response#execute(router.Router)
     */
    @Override
    public void execute(Router router) {
        router.navigate(url);
    }

}
