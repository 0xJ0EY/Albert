package table;

import table.cells.Cell;
import table.views.CellView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Class Row.
 *
 */
public class Row {

    /** The table. */
    private Table table;
    
    /** The cells. */
    private ArrayList<Cell> cells = new ArrayList<>();

    /** The values. */
    private HashMap<String, Object> values;

    /**
     * Instantiates a new row.
     *
     * @param table the table
     */
    public Row(Table table) {
        this.setTable(table);
    }

    /**
     * Sets the table.
     *
     * @param table the new table
     */
    private void setTable(Table table) {
        this.table = table;
    }

    /**
     * Gets the table.
     *
     * @return the table
     */
    public Table getTable() {
        return table;
    }

    /**
     * Adds the cell.
     *
     * @param value the value
     */
    public void addCell(Cell value) {
        value.setRow(this);
        this.cells.add(value);
    }

    /**
     * Gets the cells.
     *
     * @return the cells
     */
    public ArrayList<Cell> getCells() {
        return this.cells;
    }

    /**
     * Sets the values.
     *
     * @param values the values
     */
    public void setValues(HashMap<String, Object> values) {
        this.values = values;
    }

    /**
     * Gets the value.
     *
     * @param key the key
     * @return the value
     */
    public Object getValue(String key) {
        return this.values.get(key);
    }

    /**
     * Gets the values.
     *
     * @return the values
     */
    public HashMap<String, Object> getValues() {
        return this.values;
    }

}
