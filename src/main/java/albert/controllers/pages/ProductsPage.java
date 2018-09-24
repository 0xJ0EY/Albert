package albert.controllers.pages;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.views.PageView;
import albert.views.pages.ProductsView;
import javafx.scene.layout.AnchorPane;

public class ProductsPage implements PageController {

    private TemplateController template;
    private PageView view;

    public ProductsPage() {
        this.setView(new ProductsView());
    }

    @Override
    public void setView(PageView view) {
        this.view = view;
        this.view.load();
    }

    @Override
    public void setTemplate(TemplateController template) {
        this.template = template;
    }

    @Override
    public AnchorPane render() {
        return view.render();
    }

}
