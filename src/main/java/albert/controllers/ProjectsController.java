package albert.controllers;

import albert.dao.ProjectDAO;
import albert.models.Project;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;

public class ProjectsController extends PageController implements OverviewPage, DetailPage, EditPage, CreateObject {

    ProjectDAO dao = new ProjectDAO();
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

    @Override
    public Response edit(Request request) {
        return new ViewResponse(this);
    }

    @Override
    public void createObj(Object obj) {
      dao.create((Project)obj);
    }
}
