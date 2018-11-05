package albert.controllers;

import albert.dao.ExpenseDAO;
import albert.models.Expense;
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

import java.util.Calendar;
import java.util.Date;

public class ExpenseController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    Expense expense;
    ExpenseDAO dao = new ExpenseDAO();
    private Request request;


    public ExpenseController(PageView view, TemplateController template) {

        super(view, template);
    }

    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("expense")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("expenses/detail/{expense_id}/", this))
        );

        table.addCol(new Column("price::text",
                new LeftHeaderViewFactory("Bedrag"),
                new TextCellFactory())
        );

        table.addCol(new Column("description",
                new LeftHeaderViewFactory("Beschrijving"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(created_at, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Aangemaakt op"),
                new TextCellFactory())
        );

        return table;
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

    public void setExpense(int id) {
        this.expense = dao.loadById(id);
    }

    public Expense getExpense(){
        return this.expense;
    }

    public Request getRequest() {
        return request;
    }

    public void saveExpense(double price, String description, String name){

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

        expense = new Expense();
        expense.setPrice(price);
        expense.setDescription(description);
        expense.setName(name);
        expense.setCreated_at(currentTimestamp);
        dao.create(expense);

    }

}
