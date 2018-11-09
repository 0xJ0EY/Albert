package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.views.InvoiceEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating InvoiceEditPage objects.
 * @author
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
