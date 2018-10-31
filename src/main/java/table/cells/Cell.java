package table.cells;

import table.Row;
import table.views.CellView;

import java.util.ArrayList;

public interface Cell {

    public void setView(CellView view);

    public void setValue(Object value);

    public void setRow(Row row);

    public CellView getView();

    public Object getValue();

    public ArrayList<String> getExtraColumns();

}
