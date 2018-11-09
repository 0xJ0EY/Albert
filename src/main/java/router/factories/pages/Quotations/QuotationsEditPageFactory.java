package router.factories.pages.Quotations;

import albert.controllers.QuotationsController;
import albert.views.ContactsEditView;
import albert.views.QuotationsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating QuotationsEditPage objects.
 * @author
 */
public class QuotationsEditPageFactory implements EditPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public EditPage create() {
        return new QuotationsController(new QuotationsEditView(), new MenuTemplateController());
    }
}
