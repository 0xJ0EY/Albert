package table;

import table.views.RowView;

public class Row {

    private RowView view;
    private Table table;

    private int index;

//    private ArrayList<Value> values;

    private Object[] data;

    public Row(Object... data) {
        this.data = data;
    }

    public void setView(RowView view) {
        this.view = view;
        this.view.setRow(this);
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public RowView getView() {
        return view;
    }

    public Table getTable() {
        return table;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object[] getData() {
        return this.data;
    }

}
