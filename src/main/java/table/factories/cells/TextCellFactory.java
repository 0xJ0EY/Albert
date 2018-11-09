package table.factories.cells;

import table.cells.Cell;
import table.cells.TextCell;
import table.views.cells.TextCellView;

/**
 * A factory for creating TextCell objects.
 *
 */
public class TextCellFactory implements CellFactory {

    /* (non-Javadoc)
     * @see table.factories.cells.CellFactory#create()
     */
    @Override
    public Cell create() {
        return new TextCell(new TextCellView());
    }

}
