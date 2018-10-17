package router.error_pages;

import albert.controllers.PageController;
import router.Request;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;

public class ErrorController extends PageController implements OverviewPage {

    public ErrorController(PageView view, TemplateController template) {
        super(view, template);
    }

    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

}
