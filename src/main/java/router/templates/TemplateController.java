package router.templates;

import albert.controllers.PageController;
import javafx.scene.Parent;
import router.Router;
import router.action.TemplateAction;
import router.pages.Page;

import java.util.HashMap;

public interface TemplateController {

    public void setPage(PageController page);

    public PageController getPage();

    public Parent render();

    public Router getRouter();

    public void addAction(String name, TemplateAction templateAction);

    public HashMap<String, TemplateAction> getActions();

}
