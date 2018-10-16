package router.factories.pages.home;

import albert.controllers.HomeController;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.HomeView;
import router.factories.pages.OverviewPageFactory;

public class HomePageFactory implements OverviewPageFactory {

    @Override
    public OverviewPage create() {
        return new HomeController(new HomeView(), new MenuTemplateController());
    }

}
