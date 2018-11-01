package albert.controllers;

import albert.models.paidState;
import query.Query;
import albert.dao.ProjectDAO;
import albert.models.Project;
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
import table.factories.cells.TextCellFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

public class ProjectsController extends PageController implements OverviewPage, DetailPage, EditPage {

    ProjectDAO dao = new ProjectDAO();
    Project project;
    paidState paidState1;
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

        table.addCol(new Column("project_naam",
                new LeftHeaderViewFactory("Naam"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("finished::text",
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
        String status = paidState.notPaid.toString();
        if(done = true) { status = paidState.paid.toString();}
        project = new Project(name, status);
    }

}
