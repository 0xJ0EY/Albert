package router.factories.pages.home;

import albert.controllers.PageController;
import albert.controllers.pages.HomeController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.pages.HomeView;
import router.factories.pages.PageFactory;

public class HomePageFactory implements PageFactory {

    @Override
    public PageController create() {
        return new HomeController(new HomeView(), new MenuTemplateController());
    }

}
