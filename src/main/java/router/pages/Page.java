package router.pages;

import router.templates.TemplateController;
import router.views.PageView;
import router.Router;

public interface Page {

    public TemplateController getTemplate();

    public void setRouter(Router router);

    public Router getRouter();

    public PageView getView();

}
