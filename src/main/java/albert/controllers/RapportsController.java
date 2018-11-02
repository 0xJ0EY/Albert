package albert.controllers;

import query.Query;
import router.Request;
import router.pages.CreatePage;
import router.pages.DetailPage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;
import table.Column;
import table.Table;
import table.factories.cells.RouteCellFactory;
import table.factories.cells.TextCellFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

public class RapportsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {


    public RapportsController(PageView view, TemplateController template) {

        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("report")),
                new SearchTableView()
        );

        table.addCol(new Column("report_id",
                new LeftHeaderViewFactory("ID"),
                new RouteCellFactory("contacts/details/{report_id}/", this))
        );

        table.addCol(new Column("start_date::text",
                new LeftHeaderViewFactory("Begindatum"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(end_date, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        return table;
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
    public Response create(Request request) {
        return new ViewResponse(this);
    }
}
