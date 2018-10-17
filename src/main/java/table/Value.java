package table;

import table.views.CellView;

public class Value {

    private CellView view;
    private Object object;
    private Row row;

    public Value(CellView view, Object object) {
        this.setView(view);
        this.setObject(object);
        this.object = object;
    }

    private void setView(CellView view) {
        this.view = view;
        this.view.setValue(this);
    }

    private void setObject(Object object) {
        this.object = object;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public CellView getView() {
        return view;
    }

    public Object getObject() {
        return this.object;
    }

}
