package albert.controllers.templates;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.views.TemplateView;
import albert.views.templates.MenuView;
import javafx.scene.Parent;

public class MenuTemplate implements TemplateController {

    private TemplateView view = new MenuView();
    private PageController page;

    @Override
    public void setPage(PageController page) {
        this.page = page;
        this.page.setTemplate(this);

        this.view.load(page);
    }

    @Override
    public Parent render() {
        return this.view.render();
    }
}
