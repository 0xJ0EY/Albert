package table.cells;

import albert.controllers.PageController;
import router.Route;
import table.Row;
import table.views.CellView;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class RouteCell.
 *
 */
public class RouteCell implements Cell {

    /** The row. */
    private Row row;
    
    /** The value. */
    private Object value;
    
    /** The view. */
    private CellView view;

    /** The route. */
    private Route route;
    
    /** The page. */
    private PageController page;

    /**
     * Instantiates a new route cell.
     *
     * @param route the route
     * @param page the page
     * @param view the view
     */
    public RouteCell(String route, PageController page, CellView view) {
        this.route = new Route(route);
        this.page = page;
        this.setView(view);
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#setView(table.views.CellView)
     */
    @Override
    public void setView(CellView view) {
        this.view = view;
        this.view.setCell(this);
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#setValue(java.lang.Object)
     */
    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#setRow(table.Row)
     */
    @Override
    public void setRow(Row row) {
        this.row = row;
    }

    /**
     * Gets the route.
     *
     * @return the route
     */
    private String getRoute() {
        return this.route.buildUrl(this.row.getValues());
    }

    /**
     * Nav.
     */
    public void nav() {
        this.page.getRouter().nav(this.getRoute());
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#getView()
     */
    @Override
    public CellView getView() {
        return this.view;
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#getValue()
     */
    @Override
    public Object getValue() {
        return this.value;
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#getExtraColumns()
     */
    @Override
    public ArrayList<String> getExtraColumns() {
        return this.route.getArgs();
    }

}
