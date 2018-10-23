package albert.controllers;

import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;
import table.Column;
import table.Table;
import table.dao.ProjectsTableDAO;
import table.dao.db.DB;
import table.factories.cells.TextCellViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.BaseTableView;

public class HomeController extends PageController implements OverviewPage, DetailPage {

    private Table overviewTable;

    public HomeController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    @Override
    public Response overview(Request request) {

        String query = DB.table("projects")
                .where("name", "=", "test")
                .where(q -> q
                        .where("name", "=", "test")
                        .orWhere("name", "like", "%test%")
                )
                .orWhere("name", "like", "%test%")
                .get();

        System.out.println("query = " + query);

        this.overviewTable = new Table(new DatabaseStrategy(new ProjectsTableDAO()), new BaseTableView());

        this.overviewTable.addCol(
            new Column(
                "name",
                new LeftHeaderViewFactory("Project naam"),
                new TextCellViewFactory()
            )
        );

        return new ViewResponse(this);
    }

    @Override
    public Response detail(Request request) {
        return new ViewResponse(this);
    }

    public Table getOverviewTable() {
        return this.overviewTable;
    }
}
