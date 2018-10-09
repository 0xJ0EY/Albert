package router.factories.pages.home;

import albert.controllers.PageController;
import albert.controllers.pages.home.HomePage;
import albert.controllers.templates.MenuTemplate;
import albert.views.pages.HomeView;
import router.factories.pages.PageFactory;

public class HomePageFactory implements PageFactory {

    @Override
    public PageController create() {
        return new HomePage(new HomeView(), new MenuTemplate());
    }

}
