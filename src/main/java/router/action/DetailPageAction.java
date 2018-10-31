package router.action;

import router.pages.DetailPage;
import router.Request;
import router.Router;
import router.factories.pages.DetailPageFactory;
import router.response.Response;


public class DetailPageAction implements Action {

    private DetailPageFactory factory;

    public  DetailPageAction(DetailPageFactory factory) {
        this.factory = factory;
    }

    @Override
    public Response execute(Router router, Request request) {
        DetailPage page = this.factory.create();

        page.setRouter(router);
        return page.detail(request);
    }

}
