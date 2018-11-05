package table.factories.cells;


import table.cells.Cell;
import table.cells.TextCell;
import table.views.cells.EditableTextCellView;
import table.views.cells.TextCellView;

public class EditableTextCellFactory implements CellFactory {

    @Override
    public Cell create() {
        return new TextCell(new EditableTextCellView());
    }

}
