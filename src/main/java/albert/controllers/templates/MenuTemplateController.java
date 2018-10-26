package albert.controllers.templates;

import albert.controllers.PageController;
import router.views.TemplateView;
import albert.views.templates.MenuView;
import javafx.scene.Parent;
import router.templates.TemplateController;

import java.util.ArrayList;

public class MenuTemplateController implements TemplateController {

    private TemplateView view = new MenuView();
    private PageController page;

    @Override
    public void setPage(PageController page) {
        this.page = page;
        this.view.setController(this);
        this.view.load(page);

    }

    @Override
    public Parent render() {
        return this.view.render();
    }
}
