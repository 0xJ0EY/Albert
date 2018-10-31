package table;

import table.cells.Cell;
import table.views.CellView;

import java.util.ArrayList;

public class Row {

    private Table table;
    private ArrayList<Cell> cells = new ArrayList<>();

    public Row(Table table) {
        this.setTable(table);
    }

    private void setTable(Table table) {
        this.table = table;
    }

    public ArrayList<CellView> getColumns() {
        ArrayList<CellView> list = new ArrayList<>();

        for (Cell value : this.cells) {
            CellView view = value.getView();

            view.load();

            view.update();

            list.add(view);
        }

        return list;
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
}
