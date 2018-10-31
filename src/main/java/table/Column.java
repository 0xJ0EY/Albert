package table;

import table.cells.Cell;
import table.factories.cells.CellFactory;
import table.factories.header.HeaderViewFactory;
import table.views.HeaderView;

import java.util.ArrayList;

public class Column {

    private String databaseColumn;
    private HeaderViewFactory headerViewFactory;
    private CellFactory cellFactory;

    public Column(
        String databaseColumn,
        HeaderViewFactory headerViewFactory,
        CellFactory cellFactory
    ) {
        this.databaseColumn = databaseColumn;
        this.headerViewFactory = headerViewFactory;
        this.cellFactory = cellFactory;
    }

    public Cell getCell() {
        return this.cellFactory.create();
    }

    public HeaderView getHeaderView() {
        return this.headerViewFactory.create();
    }

    public boolean match(Object object) {
        // TODO: Refactor

        return true;
//        return this.getView().match(object);
    }

    public String getDatabaseColumn() {
        return databaseColumn;
    }

    public ArrayList<String> getRequiredDatabaseColumns() {
        ArrayList<String> list = new ArrayList<>();

        list.add(this.getDatabaseColumn());

        list.addAll(this.getCell().getExtraColumns());

        return list;
    }
}
