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

public class QuotationsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {

    private Amount amount;
    private Quotation quotation;
    private QuotationDAO dao = new QuotationDAO();
    private Request request;
    private ProjectDAO projectdao = new ProjectDAO();
    Calendar calendar = Calendar.getInstance();
    java.util.Date now = calendar.getTime();
    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

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

    public void deleteQuotation() { dao.delete(quotation); }

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

    public ArrayList<Project> getProjects(){
        ArrayList<Project> projects = projectdao.getAll();
        return projects;
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

    public String getCurrentId(){
       return this.getRequest().getParameter("quotation");
    }

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
