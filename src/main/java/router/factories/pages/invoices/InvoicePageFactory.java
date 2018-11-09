package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.InvoiceView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

/**
 * A factory for creating InvoicePage objects.
 *
 */
public class InvoicePageFactory implements OverviewPageFactory {
    
    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new InvoicesController(new InvoiceView(), new MenuTemplateController());
    }
}
