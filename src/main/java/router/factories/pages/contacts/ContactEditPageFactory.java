package router.factories.pages.contacts;

import albert.controllers.ContactController;
import albert.controllers.HomeController;
import albert.views.ContactsEditView;
import albert.views.ContactsView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.HomeView;
import router.factories.pages.OverviewPageFactory;

/**
 * A factory for creating ContactEditPage objects.
 *
 */
public class ContactEditPageFactory implements EditPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public EditPage create() {
        return new ContactController(new ContactsEditView(), new MenuTemplateController());
    }
}
