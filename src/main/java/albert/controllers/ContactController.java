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
import table.factories.cells.RouteCellFactory;
import table.factories.cells.TextCellFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.SearchTableView;

public class ContactController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage, CreateObject {

    private ContactDAO dao = new ContactDAO();
    public ContactController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("customer")),
                new SearchTableView()
        );

//        table.addCol(new Column("customer_id::text",
//                new LeftHeaderViewFactory("Contact ID"),
//                new RouteCellFactory("/home/{customer_id}/"))
//        );

        table.addCol(new Column("f_name",
                new LeftHeaderViewFactory("Voornaam"),
                new RouteCellFactory("/invocie/{customer_id}/", this))
        );

        table.addCol(new Column("b_name",
                new LeftHeaderViewFactory("Achternaam"),
                new TextCellFactory())
        );

        table.addCol(new Column("tel_number::text",
                new LeftHeaderViewFactory("Telefoonnummer"),
                new TextCellFactory())
        );

        table.addCol(new Column("email_address::text",
                new LeftHeaderViewFactory("E-Mail adres"),
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

        table.addCol(new Column("house_nr::text",
                new LeftHeaderViewFactory("Huisnummer"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(updated_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangepast op"),
                new TextCellFactory())
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

    @Override
    public Response create(Request request) {

        return new ViewResponse(this);
    }
    
    @Override
    public void createObj(Object obj) {
        dao.create((Contact)obj);
    }
}
