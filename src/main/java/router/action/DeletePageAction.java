package router.action;

import router.pages.DeletePage;
import router.Request;
import router.Router;
import router.factories.pages.DeletePageFactory;
import router.response.Response;
/*
Hier wordt een page verwijderd, op basis van een request
 */
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
