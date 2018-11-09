package router.pages;

import router.Request;
import router.response.Response;

/**
 * The Interface EditPage. Creates an editpage
 *
 */
public interface EditPage extends Page {

    /**
     *
     *
     * @param request the request
     * @return the response
     */
    public Response edit(Request request);

}
