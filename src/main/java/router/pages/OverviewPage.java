package router.pages;

import router.Request;
import router.response.Response;

public interface OverviewPage extends Page {

    public Response overview(Request request);

}
