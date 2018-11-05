package albert.controllers;

import albert.dao.InvoiceDAO;
import albert.models.*;
import albert.services.PdfService;
import com.itextpdf.text.DocumentException;
import javafx.fxml.FXML;
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

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;


public class InvoicesController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {
    private InvoiceDAO dao = new InvoiceDAO();
    private Amount amount;
    private Invoice invoice;

    private Request request;

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
                new RouteCellFactory("invoices/detail/{invoice_id}/", this))
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

    public void createInvoice(String price, String hours, Boolean betaald, Timestamp deliveryDate) {
        amount = new Amount(new Double(price), new Double(hours));
        Tax tax = new Tax("btw", 21);
        invoice = new Invoice();
        invoice.setPaid(betaald);
        invoice.setDeliveryDate(deliveryDate);
        invoice.setTax(tax);

    }

    public Table getPaidOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("invoice").where("paid", "=", "paid")),
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

    public void saveInvoice(String price, String hours, Boolean betaald, Timestamp deliveryDate, Invoice invoice) {
        invoice.getAmount().setPrice(new Double(price));
        invoice.getAmount().setHours(new Double(hours));
        invoice.setPaid(betaald);
        invoice.setDeliveryDate(deliveryDate);
        dao.update(invoice);
    }

    public void deleteInvoice(Invoice invoice) {
        dao.delete(invoice);
    }

    public Invoice getInvoice() { return this.invoice; }

    @Override
    public Response overview(Request request) {
        this.request = request;
        return new ViewResponse(this);
    }

    @Override
    public Response detail(Request request) {
        this.request = request;
        return new ViewResponse(this);
    }


    @Override
    public Response edit(Request request) {
        this.request = request;
        return new ViewResponse(this);
    }

    @Override
    public Response create(Request request) {
        this.request = request;
        return new ViewResponse(this);
    }

    public void setInvoice(int id) {
        this.invoice = dao.loadById(id);
    }

    public Request getRequest() {
        return request;
    }

}
