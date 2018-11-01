package table.factories.cells;

import albert.controllers.PageController;
import table.cells.Cell;
import table.cells.RouteCell;
import table.views.cells.RouteCellView;

public class RouteCellFactory implements CellFactory {

    private String route;
    private PageController page;

    public RouteCellFactory(String route, PageController page) {
        this.route = route;
        this.page = page;
    }

    @Override
    public Cell create() {
        return new RouteCell(this.route, this.page, new RouteCellView());
    }

}
