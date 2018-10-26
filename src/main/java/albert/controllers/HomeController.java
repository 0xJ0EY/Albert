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
import table.dao.db.Query;
import table.factories.cells.TextCellViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.BareTableView;
import table.views.tables.BaseTableView;
import table.views.tables.SearchTableView;

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
