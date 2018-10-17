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
import table.factories.columns.IntColumnViewFactory;
import table.factories.columns.TextColumnViewFactory;
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

        this.overviewTable = new Table(new DatabaseStrategy(), new BaseTableView());
        this.overviewTable.addCol(new Column("firstname", new TextColumnViewFactory()));
        this.overviewTable.addCol(new Column("age", new IntColumnViewFactory()));

        this.overviewTable.addRow("Joey", 20);
        this.overviewTable.addRow("Johhny", 50);

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
