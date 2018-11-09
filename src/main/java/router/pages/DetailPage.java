package router.pages;

import router.Request;
import router.response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Interface DetailPage.
 * @author
 */
public interface DetailPage extends Page {

    /**
     * Detail.
     *
     * @param request the request
     * @return the response
     */
    public Response detail(Request request);

}
