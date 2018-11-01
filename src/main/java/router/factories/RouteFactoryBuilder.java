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
import router.factories.pages.home.HomePageFactory;
import router.factories.pages.invoices.InvoiceCreatePageFactory;
import router.factories.pages.invoices.InvoiceDetailPageFactory;
import router.factories.pages.invoices.InvoiceEditPageFactory;
import router.factories.pages.invoices.InvoicePageFactory;
import router.factories.pages.projects.ProjectsCreatePageFactory;
import router.factories.pages.projects.ProjectsDetailPageFactory;
import router.factories.pages.projects.ProjectsEditPageFactory;
import router.factories.pages.projects.ProjectsPageFactory;
import router.factories.pages.rapports.RapportsDetailPageFactory;
import router.factories.pages.rapports.RapportsEditPageFactory;
import router.factories.pages.rapports.RapportsPageFactory;
import router.factories.pages.settings.SettingsEditPageFactory;
import router.factories.pages.settings.SettingsPageFactory;

import java.util.HashMap;
/*
De RouteFactoryBuilder zorgt dat de app op de juiste factory staat.
 */
public class RouteFactoryBuilder {

    public HashMap<Route, Action> routes() {
        HashMap<Route, Action> map = new HashMap<>();

        // Home
        map.put(new Route("home/"), new OverviewPageAction(new HomePageFactory()));

        // Projects
        map.put(new Route("projects/"), new OverviewPageAction(new ProjectsPageFactory()));
        map.put(new Route("projects/details/{project}/"), new DetailPageAction(new ProjectsDetailPageFactory()));
        map.put(new Route("projects/edit/{project}/"), new EditPageAction(new ProjectsEditPageFactory()));
        map.put(new Route("projects/create/{project}"), new CreatePageAction(new ProjectsCreatePageFactory()));

        //Contacts
        map.put(new Route("contacts/"), new OverviewPageAction(new ContactPageFactory()));
        map.put(new Route("contacts/details/{contacts}/"), new DetailPageAction(new ContactDetailPageFactory()));
        map.put(new Route("contacts/edit/{contacts}/"), new EditPageAction(new ContactEditPageFactory()));
        map.put(new Route("contacts/create/{contact}"), new CreatePageAction(new ContactCreatePageFactory()));

        //Invoices
        map.put(new Route("invoices/"), new OverviewPageAction(new InvoicePageFactory()));
        map.put(new Route("invoices/edit/{invoice}/"), new EditPageAction(new InvoiceEditPageFactory()));
        map.put(new Route("invoices/detail/{invoice}/"), new DetailPageAction(new InvoiceDetailPageFactory()));
        map.put(new Route("invoices/create/{invoice}"), new CreatePageAction(new InvoiceCreatePageFactory()));


        //Quotations
        map.put(new Route("quotations/"), new OverviewPageAction(new QuotationsPageFactory()));
        map.put(new Route("quotations/edit/{quotation}/"), new EditPageAction(new QuotationsEditPageFactory()));
        map.put(new Route("quotations/detail/{quotation}/"), new DetailPageAction(new QuotationsDetailPageFactory()));
        map.put(new Route("quotations/create/{quotation}"), new CreatePageAction(new QuotationsCreatePageFactory()));



        //Reports
        map.put(new Route("reports/"), new OverviewPageAction(new RapportsPageFactory()));
        map.put(new Route("reports/edit/{rapport}/"), new EditPageAction(new RapportsEditPageFactory()));
        map.put(new Route("reports/detail/{rapport}/"), new DetailPageAction(new RapportsDetailPageFactory()));


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
