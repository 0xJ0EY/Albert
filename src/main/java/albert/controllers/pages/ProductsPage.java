package albert.controllers.pages;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.views.PageView;
import albert.views.pages.HomeView;
import albert.views.pages.ProductsView;
import javafx.scene.layout.AnchorPane;
import router.Request;
import router.Router;
import router.response.Response;
import router.response.ViewResponse;

import java.io.IOException;

public class ProductsPage implements PageController {

    private TemplateController template;
    private PageView view;

    public ProductsPage(TemplateController template) {
        this.setView(new ProductsView());
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

        System.out.println("request = " + request.getParameters());

        return new ViewResponse(this);
    }
}
