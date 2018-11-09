package albert.controllers;

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

// TODO: Auto-generated Javadoc
/**
 * The Class RapportsController.
 * @author
 */
public class RapportsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {


    /**
     * Instantiates a new rapports controller.
     *
     * @param view the view
     * @param template the template
     */
    public RapportsController(PageView view, TemplateController template) {

        super(view, template);
    }

    /**
     * Gets the overview table.
     *
     * @return the overview table
     */
    public Table getOverviewTable(){
        Table table = new Table(
                new DatabaseStrategy(Query.table("report")),
                new SearchTableView()
        );

        table.addCol(new Column("report_id",
                new LeftHeaderViewFactory("ID"),
                new RouteCellFactory("contacts/details/{report_id}/", this))
        );

        table.addCol(new Column("TO_CHAR(start_date, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Begindatum"),
                new TextCellFactory())
        );

        table.addCol(new Column("TO_CHAR(end_date, 'DD-MM-YYYY')",
                new LeftHeaderViewFactory("Einddatum"),
                new TextCellFactory())
        );

        return table;
    }

    /* (non-Javadoc)
     * @see router.pages.OverviewPage#overview(router.Request)
     */
    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

    /* (non-Javadoc)
     * @see router.pages.DetailPage#detail(router.Request)
     */
    @Override
    public Response detail(Request request) {
        return new ViewResponse(this);
    }

    /* (non-Javadoc)
     * @see router.pages.EditPage#edit(router.Request)
     */
    @Override
    public Response edit(Request request) {
        return new ViewResponse(this);
    }

    /* (non-Javadoc)
     * @see router.pages.CreatePage#create(router.Request)
     */
    @Override
    public Response create(Request request) {
        return new ViewResponse(this);
    }
}
