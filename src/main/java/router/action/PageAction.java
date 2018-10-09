package router.action;

import albert.controllers.PageController;
import router.Request;
import router.Router;
import router.response.Response;

public class PageAction implements Action {

    private PageController page;

    public  PageAction(PageController page) {
        this.page = page;
    }

    @Override
    public Response execute(Router router, Request request) {
        return this.page.request(request);
    }
}
