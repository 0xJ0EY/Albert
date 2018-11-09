package router.factories.pages.contacts;

import albert.controllers.ContactController;
import albert.views.ContactDetailView;
import router.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import router.factories.pages.DetailPageFactory;

/**
 * A factory for creating ContactDetailPage objects.
 *
 */
public class ContactDetailPageFactory implements DetailPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public DetailPage create() {
        return new ContactController(new ContactDetailView(), new MenuTemplateController());
    }

}
