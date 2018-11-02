package albert.controllers;

import query.Query;
import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;
import table.Table;

public class HomeController extends PageController implements OverviewPage, DetailPage {

    public HomeController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

    @Override
    public Response detail(Request request) {
        return new ViewResponse(this);
    }

}
