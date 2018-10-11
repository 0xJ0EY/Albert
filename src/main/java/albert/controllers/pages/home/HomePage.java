package albert.controllers.pages.home;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.views.PageView;
import albert.views.pages.HomeView;
import javafx.scene.layout.AnchorPane;
import router.Request;
import router.Router;
import router.response.Response;
import router.response.ViewResponse;

import java.io.IOException;

public class HomePage implements PageController {

    private TemplateController template;
    private Router router;
    private PageView view;

    public HomePage(
            PageView view,
            TemplateController template
    ) {
        this.setView(view);
        this.setTemplate(template);
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
