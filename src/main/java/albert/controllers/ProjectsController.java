package albert.controllers;

import albert.dao.ContactDAO;
import albert.dao.*;
import albert.models.PaidState;
import query.Query;
import albert.dao.ProjectDAO;
import albert.models.Project;
import router.pages.CreatePage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;
import table.Column;
import table.Table;
import table.factories.cells.RouteCellFactory;
import table.factories.cells.TextCellFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

public class ProjectsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    ProjectDAO dao = new ProjectDAO();
    ContactDAO contactDAO = new ContactDAO();
    ExpenseDAO expenseDAO = new ExpenseDAO();
    InvoiceDAO invoiceDAO  = new InvoiceDAO();

    Project project;
    PaidState paidState1;
    public ProjectsController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("project")),
                new SearchTableView()
        );

        table.addCol(new Column("project_id::text",
                new LeftHeaderViewFactory("Project ID"),
                new TextCellFactory())
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("projects/details/{project}/", this))
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("done::text",
                new LeftHeaderViewFactory("Afgerond"),
                new TextCellFactory())
        );

        return  table;
    }

    public Table getDoneOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("project").where("done", "=", "true")),
                new SearchTableView()
        );

        table.addCol(new Column("project_id::text",
                new LeftHeaderViewFactory("Project ID"),
                new TextCellFactory())
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("done::text",
                new LeftHeaderViewFactory("Afgerond"),
                new TextCellFactory())
        );

        return  table;
    }
  
    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

    @Override
    public Response detail(Request request) {
        return new ViewResponse(this);
    }

    @Override
    public Response edit(Request request) {
        return new ViewResponse(this);
    }

    public void saveProject(String name, Boolean done){
        String status = PaidState.notPaid.toString();
        if(done = true) { status = PaidState.paid.toString();}
        project = new Project(name, status);


        dao.create(project);
    }

    public void editProject(){

        dao.update(project);
    }

    @Override
    public Response create(Request request) {
        return new ViewResponse(this);

    }
}
