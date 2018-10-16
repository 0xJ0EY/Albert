package albert.controllers.templates;

import albert.controllers.PageController;
import router.views.TemplateView;
import albert.views.templates.MenuView;
import javafx.scene.Parent;
import router.templates.TemplateController;

public class MenuTemplateController implements TemplateController {

    private TemplateView view = new MenuView();
    private PageController page;

    @Override
    public void setPage(PageController page) {
        this.page = page;
        this.view.setController(this);
        this.view.load();
    }

    @Override
    public PageController getPage() {
        return this.page;
    }

    @Override
    public Parent render() {

        this.view.update();

        return this.view.render();
    }
}
