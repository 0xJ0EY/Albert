package table;

import table.views.ColumnView;

public class Value {

    ColumnView view;
    Object object;

    public Value(ColumnView view, Object object) {
        this.setView(view);
        this.setObject(object);
        this.object = object;
    }

    private void setView(ColumnView view) {
        this.view = view;
        this.view.setValue(this);
    }

    private void setObject(Object object) {
        this.object = object;
    }

    public ColumnView getView() {
        return view;
    }

    public Object getObject() {
        return this.object;
    }

}
