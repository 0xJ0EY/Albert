package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.InvoiceCreateView;
import albert.views.ProjectsCreateView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

/**
 * A factory for creating InvoiceCreatePage objects.
 *
 */
public class InvoiceCreatePageFactory implements CreatePageFactory {
    
    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public CreatePage create() {
        return new InvoicesController(new InvoiceCreateView(), new MenuTemplateController());

    }
}
