package table;

import table.factories.columns.ColumnViewFactory;
import table.views.ColumnView;

public class Column {

    private Row row;

    private String name;
    private ColumnViewFactory viewFactory;

    public Column(String name, ColumnViewFactory viewFactory) {
        this.name = name;
        this.viewFactory = viewFactory;
    }

    public String getName() {
        return this.name;
    }

    public ColumnView getView() {
        return this.viewFactory.create();
    }

    public boolean match(Object object) {
        return object.getClass() == this.getView().getObjectClass();
    }
}
