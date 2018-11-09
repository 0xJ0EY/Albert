package router.factories.pages.Quotations;

import albert.controllers.QuotationsController;
import albert.views.ContactsEditView;
import albert.views.QuotationsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

/**
 * A factory for creating QuotationsEditPage objects.
 *
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
