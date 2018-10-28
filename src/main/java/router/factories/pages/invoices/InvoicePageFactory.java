package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.InvoiceView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

public class InvoicePageFactory implements OverviewPageFactory {
    @Override
    public OverviewPage create() {
        return new InvoicesController(new InvoiceView(), new MenuTemplateController());
    }
}
