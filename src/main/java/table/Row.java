package table;

import table.views.ColumnView;

import java.util.ArrayList;

public class Row {

    private Table table;

    private int index;
    private ArrayList<Value> values = new ArrayList<>();

    public Row(int index, Table table) {
        this.setIndex(index);
        this.setTable(table);
    }

    private void setTable(Table table) {
        this.table = table;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<ColumnView> getColumns() {
        ArrayList<ColumnView> list = new ArrayList<>();

        for (Value value : this.values) {
            ColumnView view = value.getView();

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
        this.values.add(value);
    }

    public ArrayList<Value> getValues() {
        return this.values;
    }
}
