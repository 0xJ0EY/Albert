package albert.controllers;

import albert.dao.ProjectDAO;
import albert.dao.QuotationDAO;
import albert.models.Amount;
import albert.models.Project;
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

// TODO: Auto-generated Javadoc
/**
 * The Class QuotationsController.
 * @author
 */
public class QuotationsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    /** The amount. */
    private Amount amount;
    
    /** The quotation. */
    private Quotation quotation;
    
    /** The dao. */
    private QuotationDAO dao = new QuotationDAO();
    
    /** The request. */
    private Request request;
    
    /** The projectdao. */
    private ProjectDAO projectdao = new ProjectDAO();
    
    /** The calendar. */
    Calendar calendar = Calendar.getInstance();
    
    /** The now. */
    java.util.Date now = calendar.getTime();
    
    /** The current timestamp. */
    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

    /**
     * Instantiates a new quotations controller.
     *
     * @param view the view
     * @param template the template
     */
    public QuotationsController(PageView view, TemplateController template) {
        super(view, template);
    }

    /**
     * Gets the overview table.
     *
     * @return the overview table
     */
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

        table.addCol(new Column("hours_expected::text",
                new LeftHeaderViewFactory("Verwachte uren"),
                new TextCellFactory())
        );

        table.addCol(new Column("null",
                new CenterHeaderViewFactory("Aanpassen"),
                new EditCellFactory("quotations/edit/{quotation_id}/", this))
        );

        return table;
    }

    /**
     * Save quotation.
     *
     * @param name the name
     * @param product the product
     * @param expectedhours the expectedhours
     * @param expectedprice the expectedprice
     * @param projectID the project ID
     * @param description the description
     */
    public void saveQuotation(String name, String product, double expectedhours, double expectedprice, int projectID, String description) {
        quotation = new Quotation();
        quotation.setName(name);
        quotation.setExpectedPrice(expectedprice);
        quotation.setExpectedHours(expectedhours);
        quotation.setDescription(description);
        quotation.setProduct(product);
        quotation.setProject(projectdao.loadById(projectID));
        quotation.setCreated_at(currentTimestamp);

        dao.create(quotation);
    }

    /**
     * Delete quotation.
     */
    public void deleteQuotation() { dao.delete(quotation); }

    /**
     * Update quotation.
     *
     * @param name the name
     * @param product the product
     * @param expectedhours the expectedhours
     * @param expectedprice the expectedprice
     * @param description the description
     * @param timestamp the timestamp
     */
    public void updateQuotation(String name, String product, double expectedhours, double expectedprice, String description, Timestamp timestamp) {
        quotation = new Quotation();
        quotation.setName(name);
        quotation.setExpectedPrice(expectedprice);
        quotation.setExpectedHours(expectedhours);
        quotation.setDescription(description);
        quotation.setProduct(product);
        quotation.setCreated_at(timestamp);
        quotation.setId(Integer.parseInt(this.getCurrentId()));

        dao.update(quotation);
    }

    /**
     * Gets the projects.
     *
     * @return the projects
     */
    public ArrayList<Project> getProjects(){
        ArrayList<Project> projects = projectdao.getAll();
        return projects;
    }

    /**
     * Gets the quotation.
     *
     * @return the quotation
     */
    public Quotation getQuotation() {
        return quotation;
    }

    /**
     * Sets the quotation.
     *
     * @param id the new quotation
     */
    public void setQuotation(int id) {
        this.quotation = dao.loadById(id);
    }

    /**
     * Gets the request.
     *
     * @return the request
     */
    public Request getRequest() {
        return request;
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
     * Gets the current id.
     *
     * @return the current id
     */
    public String getCurrentId(){
       return this.getRequest().getParameter("quotation");
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
