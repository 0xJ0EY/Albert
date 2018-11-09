package router.factories.pages.contacts;

import albert.controllers.ContactController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ContactCreateView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

/**
 * A factory for creating ContactCreatePage objects.
 *
 */
public class ContactCreatePageFactory implements CreatePageFactory {
    
    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public CreatePage create() {
        return new ContactController(new ContactCreateView(), new MenuTemplateController());

    }
}
