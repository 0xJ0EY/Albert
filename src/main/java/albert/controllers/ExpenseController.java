package albert.controllers;

import albert.dao.ExpenseDAO;
import albert.dao.ProjectDAO;
import albert.models.Expense;
import albert.models.Project;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * The Class ExpenseController.
 *
 */
public class ExpenseController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    /** The expense. */
    private Expense expense;
    
    /** The dao. */
    private ExpenseDAO dao = new ExpenseDAO();
    
    /** The project DAO. */
    private ProjectDAO projectDAO = new ProjectDAO();
    
    /** The request. */
    private Request request;

    /** The calendar. */
    Calendar calendar = Calendar.getInstance();
    
    /** The now. */
    java.util.Date now = calendar.getTime();
    
    /** The current timestamp. */
    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

    /**
     * Instantiates a new expense controller.
     *
     * @param view the view
     * @param template the template
     */
    public ExpenseController(PageView view, TemplateController template) {

        super(view, template);
    }

    /**
     * Gets the overview table.
     *
     * @return the overview table
     */
    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("expense")),
                new SearchTableView()
        );

        table.addCol(new Column("name",
                new LeftHeaderViewFactory("Naam"),
                new RouteCellFactory("expenses/detail/{expense_id}/", this))
        );

        table.addCol(new Column("'\u20AC' || price::text",
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

        table.addCol(new Column("null",
                new CenterHeaderViewFactory("Aanpassen"),
                new EditCellFactory("expenses/edit/{expense_id}/", this))
        );

        return table;
    }

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
     * Navigate edit expense.
     */
    public void navigateEditExpense(){
        this.getRouter().nav("expenses/edit/"+ this.getRequest().getParameter("expense") + "/");
    }
    
    /**
     * Edits the expense.
     *
     * @param expenseID the expense ID
     * @param name the name
     * @param price the price
     * @param description the description
     */
    public void editExpense(int expenseID, String name, double price, String description){
        expense.setId(expenseID);
        expense.setName(name);
        expense.setPrice(price);
        expense.setDescription(description);
        dao.update(expense);
        this.getRouter().nav("expenses/detail/"+ expenseID + "/");
    }
    
    /**
     * Sets the expense.
     *
     * @param id the new expense
     */
    public void setExpense(int id) {
        this.expense = dao.loadById(id);
    }

    /**
     * Gets the expense.
     *
     * @return the expense
     */
    public Expense getExpense(){
        return this.expense;
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
     * Save expense.
     *
     * @param price the price
     * @param description the description
     * @param name the name
     * @param projectID the project ID
     */
    public void saveExpense(double price, String description, String name, int projectID){

        expense = new Expense();
        expense.setProject(projectDAO.loadById(projectID));
        expense.setPrice(price);
        expense.setDescription(description);
        expense.setName(name);
        expense.setCreated_at(currentTimestamp);

        dao.create(expense);
    }

    /**
     * Gets the projects.
     *
     * @return the projects
     */
    public ArrayList<Project> getProjects(){
        ArrayList<Project> projects = projectDAO.getAll();
        return projects;
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
}
