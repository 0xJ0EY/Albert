package albert.controllers;

import albert.dao.InvoiceDAO;
import albert.models.Amount;
import albert.models.Invoice;
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
import table.factories.cells.TextCellFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;


public class InvoicesController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {
    private InvoiceDAO dao = new InvoiceDAO();
    private Amount amount;
    private Invoice invoice;

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
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(deliverydate, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Afleverdatum"),
                new TextCellFactory())
        );

        table.addCol(new Column("paid::text",
                new LeftHeaderViewFactory("Betaald"),
                new TextCellFactory())
        );

        return  table;
    }

    public void saveInvoice(String name, String price, String hours, String contact, String delivery) {
        amount = new Amount(new Double(price), new Double(hours), contact);
        invoice = new Invoice(name, amount, delivery);
        dao.create(invoice);
    }

    public void deleteInvoice() {
        dao.delete(invoice);
    }

    public void editInvoice(String name, String price, String hours, String contact, String delivery) {
        amount = new Amount(new Double(price), new Double(hours), contact);
        invoice = new Invoice(name, amount, delivery);
        dao.update(invoice);
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
