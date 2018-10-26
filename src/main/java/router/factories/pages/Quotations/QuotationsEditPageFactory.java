package router.factories.pages.Quotations;

import albert.controllers.QuotationsController;
import albert.views.ContactsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

public class QuotationsEditPageFactory implements EditPageFactory {

    @Override
    public EditPage create() {
        return new QuotationsController(new ContactsEditView(), new MenuTemplateController());
    }
}
