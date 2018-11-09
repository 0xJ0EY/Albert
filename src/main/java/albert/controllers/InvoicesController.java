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
import table.factories.cells.EditCellFactory;
import table.factories.cells.RouteCellFactory;
import table.factories.cells.TextCellFactory;
import table.factories.header.CenterHeaderViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class InvoicesController.
 * @author
 */
public class InvoicesController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {
    
    /** The dao. */
    private InvoiceDAO dao = new InvoiceDAO();
    
    /** The dao project. */
    private ProjectDAO daoProject = new ProjectDAO();
    
    /** The dao contact. */
    private ContactDAO daoContact = new ContactDAO();
    
    /** The amount. */
    private Amount amount;
    
    /** The invoice. */
    private Invoice invoice;
    
    /** The request. */
    private Request request;

    /**
     * Instantiates a new invoices controller.
     *
     * @param view the view
     * @param template the template
     */
    public InvoicesController(PageView view, TemplateController template) {
        super(view, template);
    }

    /**
     * Gets the overview table.
     *
     * @return the overview table
     */
    public Table getOverviewTable(){
        Table table = new Table(
            new DatabaseStrategy(Query.table("invoice")
                .where("paid", "=", false)),
            new SearchTableView()
        );

        table.addCol(new Column("invoice_id::text",
            new LeftHeaderViewFactory("Invoice ID"),
            new RouteCellFactory("invoices/detail/{invoice_id}/", this))
        );

        table.addCol(new Column("description",
            new LeftHeaderViewFactory("Beschrijving"),
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

        table.addCol(new Column("null",
                new CenterHeaderViewFactory("Aanpassen"),
                new EditCellFactory("invoices/edit/{invoice_id}/", this))
        );

        return  table;
    }

    /**
     * Creates the invoice.
     *
     * @param price the price
     * @param hours the hours
     * @param betaald the betaald
     * @param deliveryDate the delivery date
     * @param projectId the project id
     * @param description the description
     * @param contactName the contact name
     */
    public void createInvoice(String price, String hours, Boolean betaald, Timestamp deliveryDate, int projectId, String description, String contactName) {
        amount = new Amount();
        amount.setHours(new Double(hours));
        amount.setPrice(new Double(price));
        amount.setContact(daoContact.loadById(this.getContactIdFromName(contactName)));

        AmountDAO amountDAO = new AmountDAO();
        amountDAO.create(amount);

        Amount amountHolder = amountDAO.loadById(amountDAO.getLastInsertedId());

        Tax tax = (new TaxDAO()).loadById(1);
        invoice = new Invoice();
        invoice.setPaid(betaald);
        invoice.setDeliveryDate(deliveryDate);
        invoice.setProject(daoProject.loadById(projectId));
        invoice.setTax(tax);
        invoice.setAmount(amountHolder);
        invoice.setCreated_at(new Timestamp(System.currentTimeMillis()));
        invoice.setDescription(description);
        dao.create(invoice);
    }

    /**
     * Gets the paid overview table.
     *
     * @return the paid overview table
     */
    public Table getPaidOverviewTable(){
        Table table = new Table(
            new DatabaseStrategy(Query.table("invoice")
                .where("paid", "=", true)),
            new SearchTableView()
        );

        table.addCol(new Column("invoice_id::text",
            new LeftHeaderViewFactory("Invoice ID"),
            new RouteCellFactory("invoices/detail/{invoice_id}/", this))
        );

        table.addCol(new Column("description",
                new LeftHeaderViewFactory("Beschrijving"),
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

        return  table;
    }

    /**
     * Save invoice.
     *
     * @param price the price
     * @param hours the hours
     * @param betaald the betaald
     * @param deliveryDate the delivery date
     * @param invoice the invoice
     * @param description the description
     */
    public void saveInvoice(String price, String hours, Boolean betaald, Timestamp deliveryDate, Invoice invoice, String description) {
        invoice.getAmount().setPrice(new Double(price));
        invoice.getAmount().setHours(new Double(hours));
        invoice.setPaid(betaald);
        invoice.setDeliveryDate(deliveryDate);
        invoice.setDescription(description);
        dao.update(invoice);
    }

    /**
     * Delete invoice.
     *
     * @param invoice the invoice
     */
    public void deleteInvoice(Invoice invoice) {
        dao.delete(invoice);
    }

    /**
     * Edits the invoice.
     *
     * @param name the name
     * @param price the price
     * @param hours the hours
     * @param contact the contact
     * @param delivery the delivery
     */
    public void editInvoice(String name, String price, String hours, String contact, String delivery) {

        //invoice = new Invoice(name, amount, delivery);
        dao.update(invoice);
    }

    /**
     * Gets the invoice.
     *
     * @return the invoice
     */
    public Invoice getInvoice() { return this.invoice; }

    /* (non-Javadoc)
     * @see router.pages.OverviewPage#overview(router.Request)
     */
    @Override
    public Response overview(Request request) {
        this.request = request;
        return new ViewResponse(this);
    }

    /* (non-Javadoc)
     * @see router.pages.DetailPage#detail(router.Request)
     */
    @Override
    public Response detail(Request request) {
        this.request = request;

        int invoiceId = Integer.valueOf(request.getParameter("invoice"));
        this.invoice = (new InvoiceDAO()).loadById(invoiceId);

        return new ViewResponse(this);
    }


    /* (non-Javadoc)
     * @see router.pages.EditPage#edit(router.Request)
     */
    @Override
    public Response edit(Request request) {
        this.request = request;
        return new ViewResponse(this);
    }

    /* (non-Javadoc)
     * @see router.pages.CreatePage#create(router.Request)
     */
    @Override
    public Response create(Request request) {
        this.request = request;
        return new ViewResponse(this);
    }

    /**
     * Sets the invoice.
     *
     * @param id the new invoice
     */
    public void setInvoice(int id) {
        this.invoice = dao.loadById(id);
    }

    /**
     * Gets the request.
     *
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Gets the projects.
     *
     * @return the projects
     */
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = daoProject.getAll();
        return projects;
    }

    /**
     * Gets the contacts.
     *
     * @return the contacts
     */
    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = daoContact.getAll();
        return contacts;
    }

    /**
     * Gets the project id from name.
     *
     * @param projectName the project name
     * @return the project id from name
     */
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

    /**
     * Gets the contact id from name.
     *
     * @param contactName the contact name
     * @return the contact id from name
     */
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

    /**
     * Gets the contact name from id.
     *
     * @param contactId the contact id
     * @return the contact name from id
     */
    public String getContactNameFromId(int contactId) {
        Contact placeHoldContact = daoContact.loadById(contactId);
        String contactName = placeHoldContact.getFirstName() + " " + placeHoldContact.getLastName();
        return contactName;
    }

}