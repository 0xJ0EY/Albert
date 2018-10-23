package table;

import table.factories.cells.CellViewFactory;
import table.factories.header.HeaderViewFactory;
import table.views.CellView;
import table.views.HeaderView;

public class Column {

    private String databaseColumn;
    private HeaderViewFactory headerViewFactory;
    private CellViewFactory viewFactory;

    public Column(
        String databaseColumn,
        HeaderViewFactory headerViewFactory,
        CellViewFactory viewFactory
    ) {
        this.databaseColumn = databaseColumn;
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
