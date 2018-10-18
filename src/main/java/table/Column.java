package table;

import table.factories.cells.CellViewFactory;
import table.factories.header.HeaderViewFactory;
import table.views.CellView;
import table.views.HeaderView;

public class Column {

    private HeaderViewFactory headerViewFactory;
    private CellViewFactory viewFactory;

    public Column(HeaderViewFactory headerViewFactory, CellViewFactory viewFactory) {
        this.headerViewFactory = headerViewFactory;
        this.viewFactory = viewFactory;
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
