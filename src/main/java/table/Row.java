package table;

import table.views.CellView;

import java.util.ArrayList;

public class Row {

    private Table table;
    private ArrayList<Value> values = new ArrayList<>();

    public Row(Table table) {
        this.setTable(table);
    }

    private void setTable(Table table) {
        this.table = table;
    }

    public ArrayList<CellView> getColumns() {
        ArrayList<CellView> list = new ArrayList<>();

        for (Value value : this.values) {
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

    public void addValue(Value value) {
        value.setRow(this);
        this.values.add(value);
    }

    public ArrayList<Value> getValues() {
        return this.values;
    }
}
