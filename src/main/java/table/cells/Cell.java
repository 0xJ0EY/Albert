package table.cells;

import table.Row;
import table.views.CellView;

public interface Cell {

    public void setView(CellView view);

    public void setValue(Object value);

    public void setRow(Row row);

    public CellView getView();

    public Object getValue();

}
