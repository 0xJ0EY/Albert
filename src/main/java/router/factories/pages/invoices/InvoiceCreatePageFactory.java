package router.factories.pages.invoices;

import albert.controllers.InvoicesController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.InvoiceCreateView;
import albert.views.ProjectsCreateView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

public class InvoiceCreatePageFactory implements CreatePageFactory {
    @Override
    public CreatePage create() {
        return new InvoicesController(new InvoiceCreateView(), new MenuTemplateController());

    }
}
