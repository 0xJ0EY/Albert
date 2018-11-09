package router.pages;

import router.Request;
import router.response.Response;

/**
 * The Interface CreatePage. Creates an page.
 *
 */
public interface CreatePage extends Page {

    /**
     *
     *
     * @param request the request
     * @return the response
     */
    public Response create(Request request);

}
