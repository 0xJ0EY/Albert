package albert.controllers;

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

public class ProjectsController extends PageController implements OverviewPage, DetailPage, EditPage, CreateObject {

    ProjectDAO dao = new ProjectDAO();
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

    @Override
    public void createObj(Object obj) {
      dao.create((Project)obj);
    }
}
