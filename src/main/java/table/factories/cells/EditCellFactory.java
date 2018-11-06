package table.factories.cells;

import albert.controllers.PageController;
import table.cells.Cell;
import table.cells.RouteCell;
import table.views.cells.EditCellView;
import table.views.cells.RouteCellView;

public class EditCellFactory implements CellFactory {

    private String route;
    private PageController page;

    public EditCellFactory(String route, PageController page) {
        this.route = route;
        this.page = page;
    }

    @Override
    public Cell create() {
        return new RouteCell(this.route, this.page, new EditCellView());
    }

}
