package albert.controllers;

import albert.dao.*;
import albert.models.*;
import albert.services.PdfService;
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
import java.util.ArrayList;


public class InvoicesController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {
    private InvoiceDAO dao = new InvoiceDAO();
    private ProjectDAO daoProject = new ProjectDAO();
    private ContactDAO daoContact = new ContactDAO();
    private Amount amount;
    private Invoice invoice;
    private Request request;

    public InvoicesController(PageView view, TemplateController template) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("invoice").where("paid", "=", "false")),
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


        table.addCol(new Column("PAID::text",
                new LeftHeaderViewFactory("Betaald"),
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

//        table.addCol(new Column("paid::text",
//                new LeftHeaderViewFactory("Betaald"),
//                new TextCellFactory())
//        );

        return  table;
    }

    public void createInvoice(String price, String hours, Boolean betaald, Timestamp deliveryDate, int projectId) {
        amount = new Amount();
        amount.setHours(new Double(hours));
        amount.setPrice(new Double(price));
        amount.setContact(daoContact.loadById(1));

        AmountDAO amountDAO = new AmountDAO();
        amountDAO.create(amount);
        amount = amountDAO.loadById(amountDAO.getLastInsertedId());

        Tax tax = (new TaxDAO()).loadById(1);
        invoice = new Invoice();
        invoice.setPaid(betaald);
        invoice.setDeliveryDate(deliveryDate);
        invoice.setProject(daoProject.loadById(projectId));
        invoice.setTax(tax);
        invoice.setAmount(amount);
        invoice.setCreated_at(new Timestamp(System.currentTimeMillis()));
        //TODO: VERANDER REGEL HIERBOVEN NAAR NIET STATIC
        dao.create(invoice);
    }

    public Table getPaidOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("invoice").where("paid", "=", "true")),
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

//        table.addCol(new Column("paid::text",
//                new LeftHeaderViewFactory("Betaald"),
//                new TextCellFactory())
//        );

        return  table;
    }

    public void saveInvoice(String price, String hours, Boolean betaald, Timestamp deliveryDate, Invoice invoice, String description) {
        invoice.getAmount().setPrice(new Double(price));
        invoice.getAmount().setHours(new Double(hours));
        invoice.setPaid(betaald);
        invoice.setDeliveryDate(deliveryDate);
        invoice.setDescription(description);
        dao.update(invoice);
    }

    public void deleteInvoice(Invoice invoice) {
        dao.delete(invoice);
    }

    public void editInvoice(String name, String price, String hours, String contact, String delivery) {

        //invoice = new Invoice(name, amount, delivery);
        dao.update(invoice);
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

        int invoiceId = Integer.valueOf(request.getParameter("invoice"));
        this.invoice = (new InvoiceDAO()).loadById(invoiceId);

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

    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = daoProject.getAll();
        return projects;
    }

    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = daoContact.getAll();
        return contacts;
    }

    public int getProjectIdFromName(String projectName) {
        int projectId = 0;
        ArrayList<Project> projects = this.getProjects();
        for(int i=0; i<projects.size();i++) {
            if(projects.get(i).getName().equals(projectName)) {
                projectId = projects.get(i).getId();
            }
        }
        return projectId;
    }

    public int getContactIdFromName(String contactName) {
        int contactId = 1;
        ArrayList<Contact> contacts = this.getContacts();
        for(int i=0; i<contacts.size();i++) {
            String name = contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName();
            if(name.equals(contactName)) {
                contactId = contacts.get(i).getId();
            }
        }
        return contactId;
    }

    public String getContactNameFromId(int contactId) {
        Contact placeHoldContact = daoContact.loadById(contactId);
        String contactName = placeHoldContact.getFirstName() + " " + placeHoldContact.getLastName();
        return contactName;
    }

}
