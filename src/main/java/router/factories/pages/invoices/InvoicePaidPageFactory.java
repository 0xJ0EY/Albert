package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.InvoiceViewPaid;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

public class InvoicePaidPageFactory implements OverviewPageFactory {
    @Override
    public OverviewPage create() {
        return new InvoicesController(new InvoiceViewPaid(), new MenuTemplateController());
    }
}
