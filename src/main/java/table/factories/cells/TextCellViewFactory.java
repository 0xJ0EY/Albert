package table.factories.cells;

import table.views.CellView;
import table.views.cells.TextCellView;

public class TextCellViewFactory implements CellViewFactory {

    @Override
    public CellView create() {
        return new TextCellView();
    }

}
