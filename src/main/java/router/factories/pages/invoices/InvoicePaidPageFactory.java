package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.InvoiceViewPaid;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating InvoicePaidPage objects.
 * @author
 */
public class InvoicePaidPageFactory implements OverviewPageFactory {
    
    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new InvoicesController(new InvoiceViewPaid(), new MenuTemplateController());
    }
}
