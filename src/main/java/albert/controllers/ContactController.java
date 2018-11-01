package albert.controllers;

import albert.dao.ContactDAO;
import albert.models.Contact;
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
import table.factories.cells.TextCellViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

import java.util.ArrayList;

public class ContactController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    private ContactDAO dao = new ContactDAO();

    private Contact contact;

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
//    public Table getOverviewTable(){
//        Table table = new Table(
//                new DatabaseStrategy(Query.table("customer")),
//                new SearchTableView()
//        );
//
//        table.addCol(new Column("customer_id::text",
//                new LeftHeaderViewFactory("Contact ID"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("f_name",
//                new LeftHeaderViewFactory("Voornaam"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("b_name",
//                new LeftHeaderViewFactory("Achternaam"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("tel_number::text",
//                new LeftHeaderViewFactory("Telefoonnummer"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("email_address::text",
//                new LeftHeaderViewFactory("E-Mail adres"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("postal_code::text",
//                new LeftHeaderViewFactory("Postcode"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("street_name::text",
//                new LeftHeaderViewFactory("Straatnaam"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("house_nr::text",
//                new LeftHeaderViewFactory("Huisnummer"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
//                new LeftHeaderViewFactory("Aangemaakt op"),
//                new TextCellViewFactory())
//        );
//
//        table.addCol(new Column("TO_CHAR(updated_at, 'DD-MM-YYYY')",
//                new LeftHeaderViewFactory("Aangepast op"),
//                new TextCellViewFactory())
//        );
//
//        return  table;
//    }

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
        contact = new Contact(firstName,  lastName,  houseNumber,  telephone,  postcode,  email,  website,  description,  streetName,  place);
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

        contact= new Contact(firstName,  lastName,  houseNumber,  telephone,  postcode,  email,  website,  description,  streetName,  place);
        dao.update(contact);
    }

    public void deleteContact(){
        //contact = new Contact();
        //dao.delete(contact);
    }
}
