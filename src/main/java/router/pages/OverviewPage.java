package router.pages;

import router.Request;
import router.response.Response;

/**
 * The Interface OverviewPage. Creates an overviewpages
 *
 */
public interface OverviewPage extends Page {

    /**
     *
     *
     * @param request the request
     * @return the response
     */
    public Response overview(Request request);

}
