package table;

import table.factories.cells.CellViewFactory;
import table.factories.header.HeaderViewFactory;
import table.views.CellView;
import table.views.HeaderView;

public class Column {

    private String name;
    private HeaderViewFactory headerViewFactory;
    private CellViewFactory viewFactory;

    public Column(String name,
                  HeaderViewFactory headerViewFactory,
                  CellViewFactory viewFactory) {
        this.name = name;
        this.headerViewFactory = headerViewFactory;
        this.viewFactory = viewFactory;
    }

    public String getName() {
        return this.name;
    }

    public CellView getView() {
        return this.viewFactory.create();
    }

    public HeaderView getHeaderView() {
        return this.headerViewFactory.create();
    }

    public boolean match(Object object) {
        return object.getClass() == this.getView().getObjectClass();
    }
}
