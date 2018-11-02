package table;

import table.cells.Cell;
import table.views.CellView;

import java.util.ArrayList;
import java.util.HashMap;

public class Row {

    private Table table;
    private ArrayList<Cell> cells = new ArrayList<>();

    private HashMap<String, Object> values;

    public Row(Table table) {
        this.setTable(table);
    }

    private void setTable(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void addCell(Cell value) {
        value.setRow(this);
        this.cells.add(value);
    }

    public ArrayList<Cell> getCells() {
        return this.cells;
    }

    public void setValues(HashMap<String, Object> values) {
        this.values = values;
    }

    public Object getValue(String key) {
        return this.values.get(key);
    }

    public HashMap<String, Object> getValues() {
        return this.values;
    }

}
