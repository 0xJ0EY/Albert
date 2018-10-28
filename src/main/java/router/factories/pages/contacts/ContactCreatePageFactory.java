package router.factories.pages.contacts;

import albert.controllers.ContactController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ContactCreateView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

public class ContactCreatePageFactory implements CreatePageFactory {
    @Override
    public CreatePage create() {
        return new ContactController(new ContactCreateView(), new MenuTemplateController());

    }
}
