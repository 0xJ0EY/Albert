package albert.controllers;

import query.Query;
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
import table.factories.cells.TextCellViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

public class ProjectsController extends PageController implements OverviewPage, DetailPage, EditPage {

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

        table.addCol(new Column("project_id",
                new LeftHeaderViewFactory("Project ID"),
                new TextCellViewFactory())
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new TextCellViewFactory())
        );

        table.addCol(new Column("created_at",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellViewFactory())
        );

        table.addCol(new Column("afgerond",
                new LeftHeaderViewFactory("Afgerond"),
                new TextCellViewFactory())
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
}
