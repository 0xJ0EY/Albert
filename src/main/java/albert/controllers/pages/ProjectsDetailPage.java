package albert.controllers.pages;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.views.PageView;
import albert.views.pages.ProjectsDetailView;
import albert.views.pages.ProjectsView;
import javafx.scene.layout.AnchorPane;
import router.Request;
import router.Router;
import router.response.Response;
import router.response.ViewResponse;

import java.io.IOException;

public class ProjectsDetailPage implements PageController {

    private TemplateController template;
    private Router router;
    private PageView view;

    public ProjectsDetailPage(
            PageView view,
            TemplateController template,
            Router router) {
        this.setView(view);
        this.setTemplate(template);
        this.setRouter(router);
    }

    @Override
    public void setView(PageView view) {
        this.view = view;
        this.view.setController(this);
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
    public void setRouter(Router router) {
        this.router = router;
    }

    @Override
    public Router getRouter() {
        return this.router;
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
    public Response request(Request request) {
        return new ViewResponse(this);
    }
}
