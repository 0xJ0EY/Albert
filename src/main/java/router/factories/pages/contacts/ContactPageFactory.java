package router.factories.pages.contacts;

import albert.controllers.ContactController;
import albert.controllers.HomeController;
import albert.views.ContactsView;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.HomeView;
import router.factories.pages.OverviewPageFactory;

public class ContactPageFactory implements OverviewPageFactory {

    @Override
    public OverviewPage create() {
        return new ContactController(new ContactsView(), new MenuTemplateController());
    }

}
