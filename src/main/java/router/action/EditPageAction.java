package router.action;

import router.pages.EditPage;
import router.Request;
import router.Router;
import router.factories.pages.EditPageFactory;
import router.response.Response;

public class EditPageAction implements Action {

    private EditPageFactory factory;

    public EditPageAction(EditPageFactory factory) {
        this.factory = factory;
    }

    @Override
    public Response execute(Router router, Request request) {
        EditPage page = this.factory.create();

        page.setRouter(router);
        return page.edit(request);
    }

}
