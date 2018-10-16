package router.action;

import router.pages.CreatePage;
import router.Request;
import router.Router;
import router.factories.pages.CreatePageFactory;
import router.response.Response;

public class CreatePageAction implements Action {

    private CreatePageFactory factory;

    public  CreatePageAction(CreatePageFactory factory) {
        this.factory = factory;
    }

    @Override
    public Response execute(Router router, Request request) {
        CreatePage page = this.factory.create();

        page.setRouter(router);
        return page.create(request);
    }

}
