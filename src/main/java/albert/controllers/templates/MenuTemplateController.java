package albert.controllers.templates;

import albert.controllers.PageController;
import router.Router;
import router.pages.Page;
import router.views.TemplateView;
import albert.views.templates.MenuView;
import javafx.scene.Parent;
import router.templates.TemplateController;

import java.util.ArrayList;
/*
Hier is de controller klas  zorgt voor het menu pagina in de app.
 */
public class MenuTemplateController implements TemplateController {

    private TemplateView view = new MenuView();
    private PageController page;
    protected Router router;

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

    @Override
    public Router getRouter() {
        return page.getRouter();
    }


}
