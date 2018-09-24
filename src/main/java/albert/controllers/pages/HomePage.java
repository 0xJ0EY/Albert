package albert.controllers.pages;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.views.PageView;
import albert.views.pages.HomeView;
import javafx.scene.layout.AnchorPane;

public class HomePage implements PageController {

    private TemplateController template;
    private PageView view;

    public HomePage() {
        this.setView(new HomeView());
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
    }

    @Override
    public AnchorPane render() {
        return view.render();
    }
}
