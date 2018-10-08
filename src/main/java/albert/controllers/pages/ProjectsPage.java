package albert.controllers.pages;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.dao.ProjectsDAO;
import albert.models.Project;
import albert.views.PageView;
import albert.views.pages.ProjectsView;
import javafx.scene.layout.AnchorPane;
import router.Request;
import router.Router;
import router.response.Response;
import router.response.ViewResponse;

import java.io.IOException;
import java.util.ArrayList;

public class ProjectsPage implements PageController {

    private TemplateController template;
    private PageView view;

    private ArrayList<Project> projects;

    public ProjectsPage(TemplateController template) {
        this.setView(new ProjectsView());
        this.setTemplate(template);
    }

    @Override
    public void setView(PageView view) {
        this.view = view;
        this.view.load();
    }

    @Override
    public void setTemplate(TemplateController template) {
        this.template = template;

        try {
            this.template.setPage(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public TemplateController getTemplate() {
        return this.template;
    }

    @Override
    public AnchorPane render() {
        return view.render();
    }

    @Override
    public Response request(Router router, Request request) {

        int page = request.getParameter("page", int.class);

        ProjectsDAO dao = new ProjectsDAO();

        Project project = dao.loadById(page);

        System.out.println("project = " + project);

        return new ViewResponse(this);
    }
}
