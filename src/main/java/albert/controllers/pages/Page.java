package albert.controllers.pages;

import albert.controllers.templates.TemplateController;
import albert.views.PageView;
import router.Router;

public interface Page {

    public TemplateController getTemplate();

    public void setRouter(Router router);

    public Router getRouter();

    public PageView getView();

}
