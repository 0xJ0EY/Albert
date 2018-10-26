package router.factories.pages.contacts;

import albert.controllers.ContactController;
import albert.views.ContactDetailView;
import router.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import router.factories.pages.DetailPageFactory;

public class ContactDetailPageFactory implements DetailPageFactory {

    @Override
    public DetailPage create() {
        return new ContactController(new ContactDetailView(), new MenuTemplateController());
    }

}
