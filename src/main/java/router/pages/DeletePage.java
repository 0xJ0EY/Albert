package router.pages;

import router.Request;
import router.response.Response;

/**
 * The Interface DeletePage. Deletes an page.
 *
 */
public interface DeletePage extends Page {

    /**
     *
     *
     * @param request the request
     * @return the response
     */
    public Response delete(Request request);

}
