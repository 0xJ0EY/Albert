package table.cells;

import table.Row;
import table.views.CellView;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Cell.
 * @author
 */
public interface Cell {

    /**
     * Sets the view.
     *
     * @param view the new view
     */
    public void setView(CellView view);

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(Object value);

    /**
     * Sets the row.
     *
     * @param row the new row
     */
    public void setRow(Row row);

    /**
     * Gets the view.
     *
     * @return the view
     */
    public CellView getView();

    /**
     * Gets the value.
     *
     * @return the value
     */
    public Object getValue();

    /**
     * Gets the extra columns.
     *
     * @return the extra columns
     */
    public ArrayList<String> getExtraColumns();

}
