package table.factories.cells;

import table.views.CellView;
import table.views.cells.IntCellView;

public class IntCellViewFactory implements CellViewFactory {

    @Override
    public CellView create() {
        return new IntCellView();
    }
}
