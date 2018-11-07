package albert.controllers;

import albert.Client;
import albert.dao.ContactDAO;
import albert.dao.*;
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

import java.util.ArrayList;

public class ProjectsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    private Project project;
    private ProjectDAO projectDAO = new ProjectDAO();
    private ContactDAO contactDAO = new ContactDAO();
    private ExpenseDAO expenseDAO = new ExpenseDAO();
    private InvoiceDAO invoiceDAO  = new InvoiceDAO();

    public ProjectsController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
            new DatabaseStrategy(Query.table("project")
                .where("done::varchar", "=", "false")),
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
                        .where("done::varchar", "=", "true")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("projects/edit/{project_id}/", this))
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
                new DatabaseStrategy(Query.table("project")
                        .where("done::varchar", "=", "true")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("projects/edit/{project_id}/", this))
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

    public Table getQuotationTable(Project project) {
        Table table = new Table(
                new DatabaseStrategy(Query.table("project")
                        .where("done::varchar", "=", "true")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("projects/edit/{project_id}/", this))
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

    public Table getExpensesTable(Project project) {
        Table table = new Table(
                new DatabaseStrategy(Query.table("project")
                        .where("done::varchar", "=", "true")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("projects/edit/{project_id}/", this))
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
