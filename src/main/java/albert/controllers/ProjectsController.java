package albert.controllers;

import albert.controllers.pages.OverviewPage;
import albert.controllers.templates.TemplateController;
import albert.controllers.pages.DetailPage;
import albert.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;

public class ProjectsController extends PageController implements OverviewPage, DetailPage {

    public ProjectsController(
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
