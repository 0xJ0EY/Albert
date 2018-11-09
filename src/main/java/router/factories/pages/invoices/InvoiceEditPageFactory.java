package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.views.InvoiceEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

/**
 * A factory for creating InvoiceEditPage objects.
 *
 */
public class InvoiceEditPageFactory implements EditPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public EditPage create() {
        return new InvoicesController(new InvoiceEditView(), new MenuTemplateController());
    }
}
