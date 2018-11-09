package table.factories.cells;

import albert.controllers.PageController;
import table.cells.Cell;
import table.cells.RouteCell;
import table.views.cells.RouteCellView;

/**
 * A factory for creating RouteCell objects.
 *
 */
public class RouteCellFactory implements CellFactory {

    /** The route. */
    private String route;
    
    /** The page. */
    private PageController page;

    /**
     * Instantiates a new route cell factory.
     *
     * @param route the route
     * @param page the page
     */
    public RouteCellFactory(String route, PageController page) {
        this.route = route;
        this.page = page;
    }

    /* (non-Javadoc)
     * @see table.factories.cells.CellFactory#create()
     */
    @Override
    public Cell create() {
        return new RouteCell(this.route, this.page, new RouteCellView());
    }

}
