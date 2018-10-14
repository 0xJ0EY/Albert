package router.action;

import albert.controllers.pages.DeletePage;
import router.Request;
import router.Router;
import router.factories.pages.DeletePageFactory;
import router.response.Response;

public class DeletePageAction implements Action {

    private DeletePageFactory factory;

    public  DeletePageAction(DeletePageFactory factory) {
        this.factory = factory;
    }

    @Override
    public Response execute(Router router, Request request) {
        DeletePage page = this.factory.create();

        page.setRouter(router);
        return page.delete(request);
    }
}
