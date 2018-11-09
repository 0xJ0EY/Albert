package table;

import table.cells.Cell;
import table.factories.cells.CellFactory;
import table.factories.header.HeaderViewFactory;
import table.views.HeaderView;

import java.util.ArrayList;

/**
 * The Class Column.
 *
 */
public class Column {

    /** The database column. */
    private String databaseColumn;
    
    /** The header view factory. */
    private HeaderViewFactory headerViewFactory;
    
    /** The cell factory. */
    private CellFactory cellFactory;

    /**
     * Instantiates a new column.
     *
     * @param databaseColumn the database column
     * @param headerViewFactory the header view factory
     * @param cellFactory the cell factory
     */
    public Column(
        String databaseColumn,
        HeaderViewFactory headerViewFactory,
        CellFactory cellFactory
    ) {
        this.databaseColumn = databaseColumn;
        this.headerViewFactory = headerViewFactory;
        this.cellFactory = cellFactory;
    }

    /**
     * Gets the cell.
     *
     * @return the cell
     */
    public Cell getCell() {
        return this.cellFactory.create();
    }

    /**
     * Gets the header view.
     *
     * @return the header view
     */
    public HeaderView getHeaderView() {
        return this.headerViewFactory.create();
    }

    /**
     * Match.
     *
     * @param object the object
     * @return true, if successful
     */
    public boolean match(Object object) {
        // TODO: Refactor

        return true;
//        return this.getView().match(object);
    }

    /**
     * Gets the database column.
     *
     * @return the database column
     */
    public String getDatabaseColumn() {
        return databaseColumn;
    }

    /**
     * Gets the required database columns.
     *
     * @return the required database columns
     */
    public ArrayList<String> getRequiredDatabaseColumns() {
        ArrayList<String> list = new ArrayList<>();

        list.add(this.getDatabaseColumn());

        list.addAll(this.getCell().getExtraColumns());

        return list;
    }
}
