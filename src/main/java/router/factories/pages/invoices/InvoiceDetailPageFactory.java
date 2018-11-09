package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.views.InvoiceDetailView;
import router.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import router.factories.pages.DetailPageFactory;

/**
 * A factory for creating InvoiceDetailPage objects.
 *
 */
public class InvoiceDetailPageFactory implements DetailPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public DetailPage create() {
        return new InvoicesController(new InvoiceDetailView(), new MenuTemplateController());
    }

}
