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
import table.factories.cells.TextCellFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;


public class InvoicesController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {
    private InvoiceDAO dao = new InvoiceDAO();
    private Amount amount;
    private Invoice invoice;
    DecimalFormat df=new DecimalFormat("0.00");

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

    public void generatePdf() throws ParseException {
        //TODO: put invoice as parameter
        Tax tax = new Tax("btw", 21);
        Project project = new Project("Sander`s project", "open");
        Contact contact = new Contact("HeinekenBV", "Henk", "Jandeberg", "Zoeterwoudeweg", "15", "2254BB", "Leiden");
        Amount amount = new Amount(831.51, 15.0, "Henk Jandeberg");
        project.setContactList(contact);

        invoice = new Invoice("Factuur 4522", amount, "infographic");
        invoice.setId(5);
        invoice.setProject(project);
        invoice.setTax(tax);
        invoice.getTax().setTaxPart(this.calculateTax(this.invoice));
        String value = df.format(invoice.getTax().getTaxPart()+invoice.getAmount().getPrice());
        invoice.getAmount().setBcost((Double)df.parse(value));

        try {
            PdfService.getInstance().generateInvoicePdf(invoice);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public double calculateTax(Invoice invoice) {
        double taxPart = invoice.getAmountPrice() * (new Double(invoice.getTax().getPercentage()) / 100);
        taxPart = Math.round(taxPart * 100.0) / 100.0;
        return taxPart;
    }

    @Override
    public Response create(Request request) {
        return new ViewResponse(this);
    }
}
