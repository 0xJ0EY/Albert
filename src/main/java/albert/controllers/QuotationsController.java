package albert.controllers;

import albert.dao.ProjectDAO;
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
import java.sql.Timestamp;

public class QuotationsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    private Amount amount;
    private Quotation quotation;
    private QuotationDAO dao = new QuotationDAO();
    private Request request;
    private ProjectDAO projectdao = new ProjectDAO();

    public QuotationsController(PageView view, TemplateController template) {
        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("quotation")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("quotations/detail/{quotation_id}/", this))
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

        return table;
    }

    public void saveQuotation(String name, double expectedprice, int expectedhours, String description, String product, int projectID, Timestamp createdAt) {
        quotation = new Quotation();
        quotation.setName(name);
        quotation.setExpectedPrice(expectedprice);
        quotation.setExpectedHours(expectedhours);
        quotation.setDescription(description);
        quotation.setProduct(product);
        quotation.setProject(projectdao.loadById(projectID));
        quotation.setCreated_at(createdAt);


        dao.create(quotation);
    }

    public void deleteQuotation() { dao.delete(quotation); }

    public void editQuotation(String name, String price, String hour, String contact, String delivery) {
        amount = new Amount();
        amount.setPrice(new Double(price));
        amount.setHours(new Double(hour));
        quotation = new Quotation(name, amount, delivery);
        dao.update(quotation);
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(int id) {
        this.quotation = dao.loadById(id);
    }

    public Request getRequest() {
        return request;
    }

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

}
