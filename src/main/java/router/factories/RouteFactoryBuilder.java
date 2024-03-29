package router.factories;

import albert.controllers.templates.MenuTemplateController;
import router.Route;
import router.action.*;
import router.error_pages.ErrorController;
import router.error_pages.views.NotFoundView;
import router.factories.pages.Quotations.QuotationsCreatePageFactory;
import router.factories.pages.Quotations.QuotationsDetailPageFactory;
import router.factories.pages.Quotations.QuotationsEditPageFactory;
import router.factories.pages.Quotations.QuotationsPageFactory;
import router.factories.pages.contacts.ContactCreatePageFactory;
import router.factories.pages.contacts.ContactDetailPageFactory;
import router.factories.pages.contacts.ContactEditPageFactory;
import router.factories.pages.contacts.ContactPageFactory;
import router.factories.pages.expenses.ExpenseCreatePageFactory;
import router.factories.pages.expenses.ExpenseDetailPageFactory;
import router.factories.pages.expenses.ExpenseEditPageFactory;
import router.factories.pages.expenses.ExpensePageFactory;
import router.factories.pages.home.HomePageFactory;
import router.factories.pages.invoices.*;
import router.factories.pages.projects.*;
import router.factories.pages.rapports.RapportsCreatePageFactory;
import router.factories.pages.rapports.RapportsDetailPageFactory;
import router.factories.pages.rapports.RapportsEditPageFactory;
import router.factories.pages.rapports.RapportsPageFactory;
import router.factories.pages.settings.SettingsEditPageFactory;
import router.factories.pages.settings.SettingsPageFactory;

import java.util.HashMap;

/**
 * The Class RouteFactoryBuilder. Initialize the paths to the factories
 *
 */
public class RouteFactoryBuilder {

    /**
     * Routes.
     *
     * @return the hash map
     */
    public HashMap<Route, Action> routes() {
        HashMap<Route, Action> map = new HashMap<>();

        // Home
        map.put(new Route("home/"), new OverviewPageAction(new HomePageFactory()));

        // Projects
        map.put(new Route("projects/"), new OverviewPageAction(new ProjectsPageFactory()));
        map.put(new Route("projects/done/"), new OverviewPageAction(new ProjectsDonePageFactory()));
        map.put(new Route("projects/details/{project}/"), new DetailPageAction(new ProjectsDetailPageFactory()));
        map.put(new Route("projects/edit/{project}/"), new EditPageAction(new ProjectsEditPageFactory()));
        map.put(new Route("projects/create/"), new CreatePageAction(new ProjectsCreatePageFactory()));

        //Contacts
        map.put(new Route("contacts/"), new OverviewPageAction(new ContactPageFactory()));
        map.put(new Route("contacts/details/{contacts}/"), new DetailPageAction(new ContactDetailPageFactory()));
        map.put(new Route("contacts/edit/{contacts}/"), new EditPageAction(new ContactEditPageFactory()));
        map.put(new Route("contacts/create/"), new CreatePageAction(new ContactCreatePageFactory()));

        //Invoices
        map.put(new Route("invoices/"), new OverviewPageAction(new InvoicePageFactory()));
        map.put(new Route("invoicespaid/"), new OverviewPageAction(new InvoicePaidPageFactory()));
        map.put(new Route("invoices/edit/{invoice}/"), new EditPageAction(new InvoiceEditPageFactory()));
        map.put(new Route("invoices/detail/{invoice}/"), new DetailPageAction(new InvoiceDetailPageFactory()));
        map.put(new Route("invoices/create/"), new CreatePageAction(new InvoiceCreatePageFactory()));

        //Quotations
        map.put(new Route("quotations/"), new OverviewPageAction(new QuotationsPageFactory()));
        map.put(new Route("quotations/edit/{quotation}/"), new EditPageAction(new QuotationsEditPageFactory()));
        map.put(new Route("quotations/detail/{quotation}/"), new DetailPageAction(new QuotationsDetailPageFactory()));
        map.put(new Route("quotations/create/"), new CreatePageAction(new QuotationsCreatePageFactory()));

        //Expenses
        map.put(new Route("expenses/"), new OverviewPageAction(new ExpensePageFactory()));
        map.put(new Route("expenses/edit/{expense}/"), new EditPageAction(new ExpenseEditPageFactory()));
        map.put(new Route("expenses/detail/{expense}/"), new DetailPageAction(new ExpenseDetailPageFactory()));
        map.put(new Route("expenses/create/"), new CreatePageAction(new ExpenseCreatePageFactory()));

        //Reports
        map.put(new Route("reports/"), new OverviewPageAction(new RapportsPageFactory()));
        map.put(new Route("reports/edit/{rapport}/"), new EditPageAction(new RapportsEditPageFactory()));
        map.put(new Route("reports/detail/{rapport}/"), new DetailPageAction(new RapportsDetailPageFactory()));
        map.put(new Route("reports/create/"), new CreatePageAction(new RapportsCreatePageFactory()));

        //Settings
        map.put(new Route("settings/"), new OverviewPageAction(new SettingsPageFactory()));
        map.put(new Route("settings/edit/{setting}/"), new EditPageAction(new SettingsEditPageFactory()));

        // Errors
        map.put(new Route("errors/404"), new OverviewPageAction(() -> {
            return new ErrorController(new NotFoundView(), new MenuTemplateController());
        }));

        return map;
    }

}
