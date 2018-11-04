package albert.controllers;

import albert.dao.ContactDAO;
import albert.models.Contact;
import albert.models.ContactEmail;
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
import table.Table;
import table.factories.cells.RouteCellFactory;
import table.factories.cells.TextCellFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;
import table.views.tables.components.TableButton;

import java.util.ArrayList;
import java.util.Calendar;

public class ContactController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

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

    /**
     * @return
     */

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

        table.addButton(new TableButton("Toevoegen", () -> {
            this.router.nav("home/");
        }));

        return table;
    }

    public Table getOverviewEmails(Contact contact) {
        Table table = new Table(
                new DatabaseStrategy(
                    Query.table("contact")
                        .where("contact_id", "=", contact.getId())
                ),
                new SearchTableView()
        );

        table.addCol(new Column("email_address",
            new LeftHeaderViewFactory("E-mail"),
            new TextCellFactory())
        );

        return table;
    }

    public Table getOverviewPhoneNumbers(Contact contact) {
        Table table = new Table(
                new DatabaseStrategy(
                    Query.table("contact")
                        .where("contact_id", "=", contact.getId())
                ),
                new SearchTableView()
        );

        return table;
    }

    public Table getEditableEmails(Contact contact) {
        Table table = new Table(
                new DatabaseStrategy(
                    Query.table("contact")
                        .where("contact_id", "=", contact.getId())
                ),
                new SearchTableView()
        );

        return table;
    }

    public Table getEditablePhoneNumbers(Contact contact) {
        Table table = new Table(
                new DatabaseStrategy(
                    Query.table("contact")
                        .where("contact_id", "=", contact.getId())
                ),
                new SearchTableView()
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

    public void createContact(Contact contact) {
        ContactDAO dao = new ContactDAO();
        dao.create(contact);
    }

    public void updateContact(Contact contact) {
        ContactDAO dao = new ContactDAO();
        dao.update(contact);
    }

    public void deleteContact(Contact contact) {
        ContactDAO dao = new ContactDAO();
        dao.delete(contact);
    }

}