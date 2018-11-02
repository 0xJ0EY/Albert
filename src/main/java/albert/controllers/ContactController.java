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

    private ContactDAO dao = new ContactDAO();

    private Contact contact;
    private ContactEmail ContactEmail;

    /**
     *
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
     *
     * @return
     */

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("contact")),
                new SearchTableView()
        );

        table.addCol(new Column("first_name",
                new LeftHeaderViewFactory("Voornaam"),
                new RouteCellFactory("invoices/detail/{contact_id}/", this))
        );

        table.addCol(new Column("last_name",
                new LeftHeaderViewFactory("Achternaam"),
                new TextCellFactory())
        );

        table.addCol(new Column("tel_number::text",
                new LeftHeaderViewFactory("Telefoonnummer"),
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

    /**
     *
     * @param firstName
     * @param lastName
     * @param houseNumber
     * @param telephone
     * @param postcode
     * @param email
     * @param website
     * @param description
     * @param streetName
     * @param place
     */
    public void saveContact(String firstName, String lastName, String houseNumber, String telephone, String postcode, ArrayList<String> email, String website, String description, String streetName, String place) {

        ArrayList<ContactEmail> contactEmails= new ArrayList<ContactEmail>();
        for(int i= 0; i < email.size();i++){
            ContactEmail contactEmail= new ContactEmail(email.get(i));
            contactEmails.add(contactEmail);
        }


        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());


        //contact = new Contact(firstName,  lastName,  houseNumber,  telephone,  postcode,  contactEmails,  website,  description,  streetName,  place,currentTimestamp );
        dao.create(contact);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param houseNumber
     * @param telephone
     * @param postcode
     * @param email
     * @param website
     * @param description
     * @param streetName
     * @param place
     */
    public void editContact(String firstName, String lastName, String houseNumber, String telephone, String postcode, ArrayList<String> email, String website, String description, String streetName, String place){

        ArrayList<ContactEmail> contactEmails=null;
        for(int i= 0; i < email.size();i++){
            ContactEmail contactEmail= new ContactEmail(email.get(i));
            contactEmails.add(contactEmail);
        }
       // contact= new Contact(firstName,  lastName,  houseNumber,  telephone,  postcode,contactEmails,  website,  description,  streetName,  place);
       // dao.update(contact);
    }

    public void deleteContact(){
        //contact = new Contact();
        //dao.delete(contact);
    }
}
