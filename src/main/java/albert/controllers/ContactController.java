package albert.controllers;

import albert.dao.ContactDAO;
import albert.dao.ContactEmailDAO;
import albert.models.Contact;
import albert.models.ContactEmail;
import albert.models.ContactPhoneNumber;
import query.Query;
import router.pages.CreatePage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;
import table.Column;
import table.Row;
import table.Table;
import table.factories.cells.EditCellFactory;
import table.factories.cells.EditableTextCellFactory;
import table.factories.cells.RouteCellFactory;
import table.factories.cells.TextCellFactory;
import table.factories.header.CenterHeaderViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.EditTableView;
import table.views.tables.SearchTableView;
import table.views.tables.components.TableButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class ContactController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    private Contact contact;
    private Table emailsTable;
    private Table phoneNumbersTable;

    /**
     * @param view
     * @param template
     */
    public ContactController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    public Table getOverviewTable() {
        Table table = new Table(
                new DatabaseStrategy(Query.table("contact")),
                new SearchTableView()
        );

        table.addCol(new Column("first_name",
                new LeftHeaderViewFactory("Voornaam"),
                new RouteCellFactory("contacts/details/{contact_id}/", this))
        );

        table.addCol(new Column("last_name",
                new LeftHeaderViewFactory("Achternaam"),
                new TextCellFactory())
        );

        table.addCol(new Column("postal_code::text",
                new LeftHeaderViewFactory("Postcode"),
                new TextCellFactory())
        );

        table.addCol(new Column("street_name::text",
                new LeftHeaderViewFactory("Straatnaam"),
                new TextCellFactory())
        );

        table.addCol(new Column("house_number::text",
                new LeftHeaderViewFactory("Huisnummer"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("null",
                new CenterHeaderViewFactory("Aanpassen"),
                new EditCellFactory("contacts/edit/{contact_id}/", this))
        );

        return table;
    }

    private void createOverviewEmails(Contact contact) {
        Table table = new Table(
            new DatabaseStrategy(
                Query.table("contact_email")
                    .where("contact_id", "=", contact.getId())
            ),
            new SearchTableView()
        );

        table.addCol(new Column("email_address",
            new LeftHeaderViewFactory("E-mail"),
            new TextCellFactory())
        );

        this.emailsTable = table;
    }

    private void createOverviewPhoneNumbers(Contact contact) {
        Table table = new Table(
            new DatabaseStrategy(
                Query.table("contact_phone")
                    .where("contact_id", "=", contact.getId())
            ),
            new SearchTableView()
        );

        table.addCol(new Column("phone_number",
            new LeftHeaderViewFactory("Telefoonnummer"),
            new TextCellFactory())
        );

        this.phoneNumbersTable = table;
    }

    private void createEditableEmails(Contact contact) {
        Table table = new Table(
            new DatabaseStrategy(
                Query.table("contact_email")
                    .where("contact_id", "=", contact.getId())
            ),
            new EditTableView()
        );

        table.addCol(new Column("email_address",
            new LeftHeaderViewFactory("E-mail"),
            new EditableTextCellFactory())
        );

        // Add a button to add new email addresses in runtime
        HashMap<String, Object> defaultValues = new HashMap<>();
        defaultValues.put("email_address", "");

        table.addButton(new TableButton("Toevoegen", () -> {
            table.setTotalRows(table.getTotalRows() + 1);
            table.addRow(defaultValues);
            table.update();
        }));

        this.emailsTable = table;
    }

    private void createEditablePhoneNumbers(Contact contact) {
        Table table = new Table(
            new DatabaseStrategy(
                Query.table("contact_phone")
                    .where("contact_id", "=", contact.getId())

            ),
            new EditTableView()
        );

        table.addCol(new Column("phone_number",
            new LeftHeaderViewFactory("Telefoonnummer"),
            new EditableTextCellFactory())
        );

        table.limit(Integer.MAX_VALUE);

        // Add a button to add new email addresses in runtime
        HashMap<String, Object> defaultValues = new HashMap<>();
        defaultValues.put("email_address", "");

        table.addButton(new TableButton("Toevoegen", () -> {
            table.setTotalRows(table.getTotalRows() + 1);
            table.addRow(defaultValues);
            table.update();
        }));

        this.phoneNumbersTable = table;
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

        ContactDAO dao = new ContactDAO();

        long id = Long.valueOf(request.getParameter("contacts"));
        this.contact = dao.loadById(id);

        this.createEditableEmails(this.contact);
        this.createEditablePhoneNumbers(this.contact);

        return new ViewResponse(this);
    }

    @Override
    public Response create(Request request) {

        this.contact = new Contact();

        this.createEditableEmails(this.contact);
        this.createEditablePhoneNumbers(this.contact);

        return new ViewResponse(this);
    }

    public void createContact(Contact contact) {
        ContactDAO dao = new ContactDAO();

        contact = this.updateEmails(contact);
        contact = this.updatePhoneNumbers(contact);

        dao.create(contact);
    }

    public void updateContact(Contact contact) {
        ContactDAO dao = new ContactDAO();

        contact = this.updateEmails(contact);
        contact = this.updatePhoneNumbers(contact);

        dao.update(contact);
    }

    public void deleteContact(Contact contact) {
        ContactDAO dao = new ContactDAO();

        contact.setEmails(new ArrayList<>());
        contact.setPhoneNumbers(new ArrayList<>());

        dao.delete(contact);
    }

    private Contact updateEmails(Contact contact) {
        ArrayList<ContactEmail> emails = new ArrayList<>();
        HashMap<String, ContactEmail> oldEmails = new HashMap<>();

        for (ContactEmail email : contact.getEmails()) {
            oldEmails.put(email.getEmailAddress(), email);
        }

        for (Row row : this.emailsTable.getData()) {
            String email = (String) row.getCells().get(0).getValue();

            if (email.length() == 0) continue;

            if (oldEmails.get(email) != null) {
                emails.add(oldEmails.get(email));
            } else {
                ContactEmail contactEmail = new ContactEmail();
                contactEmail.setEmailAddress(email);
                contactEmail.setContact(contact);
                emails.add(contactEmail);
            }
        }


        contact.setEmails(emails);

        return contact;

    }

    private Contact updatePhoneNumbers(Contact contact) {
        ArrayList<ContactPhoneNumber> phoneNumbers = new ArrayList<>();
        HashMap<String, ContactPhoneNumber> oldPhoneNumbers = new HashMap<>();

        for (ContactPhoneNumber phoneNumber : contact.getPhoneNumbers()) {
            oldPhoneNumbers.put(phoneNumber.getPhoneNumber(), phoneNumber);
        }


        for (Row row : this.phoneNumbersTable.getData()) {
            String phone = (String) row.getCells().get(0).getValue();

            if (phone.length() == 0) continue;

            if (oldPhoneNumbers.get(phone) != null) {
                phoneNumbers.add(oldPhoneNumbers.get(phone));
            } else {
                ContactPhoneNumber contactPhoneNumber = new ContactPhoneNumber();
                contactPhoneNumber.setPhoneNumber(phone);
                contactPhoneNumber.setContact(contact);
                phoneNumbers.add(contactPhoneNumber);
            }

        }

        contact.setPhoneNumbers(phoneNumbers);

        return contact;
    }


    public Contact getContact() {
        return this.contact;
    }

    public Table getEmailsTable() {
        return this.emailsTable;
    }

    public Table getPhoneNumbersTable() {
        return this.phoneNumbersTable;
    }
}