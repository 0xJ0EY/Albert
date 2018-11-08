package albert.controllers;

import albert.Client;
import albert.dao.ContactDAO;
import albert.models.Contact;
import query.Query;
import albert.dao.ProjectDAO;
import albert.models.Project;
import router.pages.CreatePage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.response.RedirectResponse;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;
import table.Column;
import table.Table;
import table.factories.cells.EditCellFactory;
import table.factories.cells.RouteCellFactory;
import table.factories.cells.TextCellFactory;
import table.factories.header.CenterHeaderViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;
import table.views.tables.components.TableButton;

import java.util.ArrayList;

public class ProjectsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    private Project project;
    private ProjectDAO projectDAO = new ProjectDAO();
    private ContactDAO contactDAO = new ContactDAO();

    public ProjectsController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
            new DatabaseStrategy(Query.table("project")
                .where("done", "=", false)),
            new SearchTableView()
        );

        table.addCol(new Column("name",
            new LeftHeaderViewFactory("Naam"),
            new RouteCellFactory("projects/details/{project_id}/", this))
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
            new LeftHeaderViewFactory("Aangemaakt op"),
            new TextCellFactory())
        );

        table.addCol(new Column("null",
            new CenterHeaderViewFactory("Aanpassen"),
            new EditCellFactory("projects/edit/{project_id}/", this))
        );

        table.orderBy("project_id", "DESC");

        return  table;
    }

    public Table getDoneOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("project")
                        .where("done", "=", true)),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("projects/details/{project_id}/", this))
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("null",
                new CenterHeaderViewFactory("Aanpassen"),
                new EditCellFactory("projects/edit/{project_id}/", this))
        );

        table.orderBy("project_id", "DESC");

        return  table;
    }

    public Table getInvoicesTable(Project project) {
        Table table = new Table(
            new DatabaseStrategy(
                Query.table("invoice")
                    .where("project_id", "=", project.getId())),
            new SearchTableView()
        );

        table.addCol(new Column("invoice_id::text",
            new LeftHeaderViewFactory("Invoice ID"),
            new RouteCellFactory("invoices/detail/{invoice_id}/", this))
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
            new LeftHeaderViewFactory("Aangemaakt op"),
            new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(deliverydate, 'DD-MM-YYYY')",
            new LeftHeaderViewFactory("Afleverdatum"),
            new TextCellFactory())
        );

        table.addButton(
            new TableButton("Factuur toevoegen", () -> {
                this.router.nav("projects/create/");
            })
        );

        return table;
    }

    public Table getQuotationTable(Project project) {
        Table table = new Table(
            new DatabaseStrategy(
                Query.table("quotation")
                    .where("project_id", "=", project.getId())),
            new SearchTableView()
        );

        table.addCol(new Column("name",
            new LeftHeaderViewFactory("Naam"),
            new RouteCellFactory("quotations/detail/{quotation_id}/", this))
        );

        table.addCol(new Column("description",
            new LeftHeaderViewFactory("Beschrijving"),
            new TextCellFactory())
        );

        table.addCol(new Column("product",
            new LeftHeaderViewFactory("Product"),
            new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
            new LeftHeaderViewFactory("Aangemaakt op"),
            new TextCellFactory())
        );

        table.addCol(new Column("hours_expected::text",
            new LeftHeaderViewFactory("Verwachte uren"),
            new TextCellFactory())
        );

        table.addButton(
            new TableButton("Offerte toevoegen", () -> {
                this.router.nav("quotations/create/");
            })
        );

        return table;
    }

    public Table getExpensesTable(Project project) {
        Table table = new Table(
            new DatabaseStrategy(Query.table("expense")
                .where("project_id", "=", project.getId())),
            new SearchTableView()
        );

        table.addCol(new Column("name",
            new LeftHeaderViewFactory("Naam"),
            new RouteCellFactory("expenses/detail/{expense_id}/", this))
        );

        table.addCol(new Column("price::text",
            new LeftHeaderViewFactory("Bedrag"),
            new TextCellFactory())
        );

        table.addCol(new Column("description",
            new LeftHeaderViewFactory("Beschrijving"),
            new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
            new LeftHeaderViewFactory("Aangemaakt op"),
            new TextCellFactory())
        );

        table.addButton(
            new TableButton("Onkosten toevoegen", () -> {
                this.router.nav("expenses/create/");
            })
        );

        return table;
    }

    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

    @Override
    public Response detail(Request request) {
        long id = Long.valueOf(request.getParameter("project"));

        this.project = new ProjectDAO().loadById(id);

        return new ViewResponse(this);
    }

    @Override
    public Response edit(Request request) {
        long id = Long.valueOf(request.getParameter("project"));

        this.project = new ProjectDAO().loadById(id);

        return new ViewResponse(this);
    }

    public ArrayList<Contact> getContacts() {
        return this.contactDAO.getAll();
    }

    public void createProject(Project project){
        this.projectDAO.create(project);
    }

    public void updateProject(Project project){
        this.projectDAO.update(project);
    }

    @Override
    public Response create(Request request) {

        if (this.loadContacts().size() == 0) {
            Client.ShowWarning("Geen contactpersonen", "Er bestaan nog geen contactpersonen om een project op te koppelen.");
            return new RedirectResponse("projects/");
        }

        return new ViewResponse(this);

    }

    public ArrayList<Contact> loadContacts() {
        return new ContactDAO().getAll();
    }

    public Project getProject() {
        return project;
    }
}
