package router.factories.pages.contacts;

import albert.controllers.ContactController;
import albert.controllers.HomeController;
import albert.views.ContactsView;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.HomeView;
import router.factories.pages.OverviewPageFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ContactPage objects.
 * @author
 */
public class ContactPageFactory implements OverviewPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new ContactController(new ContactsView(), new MenuTemplateController());
    }

}
