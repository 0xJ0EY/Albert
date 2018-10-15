package router.factories.pages.contacts;

import albert.controllers.HomeController;
import albert.controllers.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.pages.HomeView;
import router.factories.pages.OverviewPageFactory;

public class ContactsPageFactory implements OverviewPageFactory {


    @Override
    public OverviewPage create() {
        return new HomeController(new HomeView(), new MenuTemplateController());
    }
}
