package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.InvoiceView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating InvoicePage objects.
 * @author
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
