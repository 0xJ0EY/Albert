package router.action;

import albert.controllers.PageController;
import router.Request;
import router.Router;
import router.factories.pages.PageFactory;
import router.response.Response;

public class PageAction implements Action {

    private PageFactory pageFactory;

    public  PageAction(PageFactory page) {
        this.pageFactory = page;
    }

    @Override
    public Response execute(Router router, Request request) {
        PageController page = this.pageFactory.create();

        page.setRouter(router);
        return page.request(request);
    }
}
