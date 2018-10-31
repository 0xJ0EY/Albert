package table.factories.cells;

import table.cells.Cell;
import table.cells.RouteCell;
import table.views.cells.IntCellView;
import table.views.cells.TextCellView;

public class RouteCellFactory implements CellFactory {

    private String route;

    public RouteCellFactory(String route) {
        this.route = route;
    }

    @Override
    public Cell create() {
        return new RouteCell(this.route, new IntCellView());
    }

}
