package router.pages;

import router.Request;
import router.response.Response;

public interface OverviewPage extends Page {

    /**
     *
     * @param request
     * @return
     */
    public Response overview(Request request);

}
