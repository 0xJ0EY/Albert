package router.pages;

import router.Request;
import router.response.Response;

/**
 * The Interface CreatePage.
 *
 */
public interface CreatePage extends Page {

    /**
     * Creates an page.
     *
     * @param request the request
     * @return the response
     */
    public Response create(Request request);

}
