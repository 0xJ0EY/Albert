package table.factories.cells;


import table.cells.Cell;
import table.cells.TextCell;
import table.views.cells.EditableTextCellView;
import table.views.cells.TextCellView;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating EditableTextCell objects.
 *
 */
public class EditableTextCellFactory implements CellFactory {

    /* (non-Javadoc)
     * @see table.factories.cells.CellFactory#create()
     */
    @Override
    public Cell create() {
        return new TextCell(new EditableTextCellView());
    }

}
