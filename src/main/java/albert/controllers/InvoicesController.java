package albert.controllers;

import query.Query;
import router.Request;
import router.pages.DetailPage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;
import table.Column;
import table.Table;
import table.factories.cells.TextCellViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;


public class InvoicesController extends PageController implements OverviewPage, DetailPage, EditPage {

    public InvoicesController(PageView view, TemplateController template) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("invoice")),
                new SearchTableView()
        );

        table.addCol(new Column("invoice_id::text",
                new LeftHeaderViewFactory("Invoice ID"),
                new TextCellViewFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellViewFactory())
        );

        table.addCol(new Column("TO_CHAR(deliverydate, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Afleverdatum"),
                new TextCellViewFactory())
        );

        table.addCol(new Column("amount::text",
                new LeftHeaderViewFactory("Bedrag"),
                new TextCellViewFactory())
        );

        table.addCol(new Column("paid::text",
                new LeftHeaderViewFactory("Betaald"),
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
