package table;

import table.factories.columns.ColumnViewFactory;
import table.views.ColumnView;

public class Column {

    private Row row;

    private String name;
    private ColumnView view;

    public Column(String name, ColumnViewFactory viewFactory) {
        this.name = name;
        this.view = viewFactory.create();
    }

    public String getName() {
        return this.name;
    }

    public ColumnView getView() {
        return this.view;
    }

    public boolean match(Object object) {
        return object.getClass() == this.view.getObjectClass();
    }
}
