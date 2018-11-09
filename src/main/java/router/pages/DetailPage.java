package router.pages;

import router.Request;
import router.response.Response;

/**
 * The Interface DetailPage. Creates an detailpages
 *
 */
public interface DetailPage extends Page {

    /**
     *
     *
     * @param request the request
     * @return the response
     */
    public Response detail(Request request);

}
