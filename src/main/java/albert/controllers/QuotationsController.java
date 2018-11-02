package albert.controllers;

import albert.dao.QuotationDAO;
import albert.models.Amount;
import albert.models.Quotation;
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
import table.views.tables.components.TableButton;


public class QuotationsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {
    Amount amount;
    Quotation quotation;

    private QuotationDAO dao = new QuotationDAO();

    public QuotationsController(PageView view, TemplateController template) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("quotation")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Voornaam"),
                new RouteCellFactory("contacts/details/{quotation_id}/", this))
        );

        table.addCol(new Column("description",
                new LeftHeaderViewFactory("Beschrijving"),
                new TextCellFactory())
        );

        table.addCol(new Column("product",
                new LeftHeaderViewFactory("Product"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        table.addCol(new Column("hours_expected::text",
                new LeftHeaderViewFactory("Verwachte uren"),
                new TextCellFactory())
        );

        return table;
    }

    public void saveQuotation(String name, String price, String hour, String contact, String delivery) {
        amount = new Amount(new Double(price), new Double(hour), contact);
        quotation = new Quotation(name, amount, delivery);
        dao.create(quotation);
    }

    public void deleteQuotation() { dao.delete(quotation); }

    public void editQuotation(String name, String price, String hour, String contact, String delivery) {
        //amount = new Amount(new Double(price), new Double(hour), contact);
        //quotation = new Quotation(name, amount, delivery);
        dao.update(quotation);
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
