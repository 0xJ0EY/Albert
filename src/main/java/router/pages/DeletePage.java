package router.pages;

import router.Request;
import router.response.Response;

/**
 * The Interface DeletePage.
 *
 */
public interface DeletePage extends Page {

    /**
     * Deletes an page.
     *
     * @param request the request
     * @return the response
     */
    public Response delete(Request request);

}
