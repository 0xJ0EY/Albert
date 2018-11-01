package table.factories.cells;

import table.views.CellView;
import table.views.cells.DateCellView;
import table.views.cells.TextCellView;

public class DateCellViewFactory implements CellViewFactory {

    @Override
    public CellView create() {
        return new DateCellView();
    }

}
