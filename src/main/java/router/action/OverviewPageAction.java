package router.action;

import albert.controllers.pages.OverviewPage;
import router.Request;
import router.Router;
import router.factories.pages.OverviewPageFactory;
import router.response.Response;

public class OverviewPageAction implements Action {

    private OverviewPageFactory factory;

    public  OverviewPageAction(OverviewPageFactory factory) {
        this.factory = factory;
    }

    @Override
    public Response execute(Router router, Request request) {
        OverviewPage page = this.factory.create();

        page.setRouter(router);
        return page.overview(request);
    }

}
