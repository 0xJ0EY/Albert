package table;

import javafx.application.Platform;
import table.cells.Cell;
import table.exceptions.IllegalTableChangeException;
import table.exceptions.InvalidRowException;
import table.strategies.DataStrategy;
import table.views.TableView;
import table.views.tables.components.TableButton;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Class Table.
 *
 */
public class Table {

    /** The strategy. */
    private DataStrategy strategy;
    
    /** The view. */
    private TableView view;

    /** The data runnable. */
    private DataRunnable dataRunnable;

    /** The loaded. */
    private boolean loaded = false;
    
    /** The current rows. */
    private int currentRows = 0;
    
    /** The total rows. */
    private int totalRows = 0;

    /** The buttons. */
    private ArrayList<TableButton> buttons = new ArrayList<TableButton>();
    
    /** The cols. */
    private ArrayList<Column> cols = new ArrayList<Column>();
    
    /** The data. */
    private ArrayList<Row> data = new ArrayList<Row>();

    /**
     * Instantiates a new table.
     *
     * @param strategy the strategy
     * @param view the view
     */
    public Table(DataStrategy strategy, TableView view) {
        this.setStrategy(strategy);
        this.setView(view);
    }

    /**
     * Sets the strategy.
     *
     * @param strategy the new strategy
     */
    private void setStrategy(DataStrategy strategy) {
        // Do not allow changes to the tables when it already has data.
        if (this.data.size() > 0)
            throw new IllegalTableChangeException();

        this.strategy = strategy;
        this.strategy.setTable(this);
    }

    /**
     * Sets the view.
     *
     * @param view the new view
     */
    private void setView(TableView view) {
        this.view = view;
        this.view.setTable(this);
        this.view.load();
    }

    /**
     * Fetch.
     */
    public void fetch() {
        // Clear old data set
        this.data = new ArrayList<>();
        this.loaded = false;

        // Fetch new data set
        if (this.dataRunnable != null)
            this.dataRunnable.interrupt();

        this.dataRunnable = new DataRunnable(this.strategy);
        this.dataRunnable.start();
    }

    /**
     * Gets the buttons.
     *
     * @return the buttons
     */
    public ArrayList<TableButton> getButtons() {
        return this.buttons;
    }

    /**
     * Adds the button.
     *
     * @param button the button
     */
    public void addButton(TableButton button) {
        this.buttons.add(button);
    }

    /**
     * Adds the col.
     *
     * @param col the col
     */
    public void addCol(Column col) {
        // Do not allow changes to the tables when it already has data.
        if (this.data.size() > 0)
            throw new IllegalTableChangeException();

        this.cols.add(col);
    }

    /**
     * Adds the row.
     *
     * @param map the map
     */
    public void addRow(HashMap<String, Object> map) {

        // Create new row
        Row row = new Row(this);

        // Save values
        row.setValues(map);

        // Check if the row and cells have the same data type on correct key
        // Else throw an exception
        for (int i = 0; i < cols.size(); i++) {
            Column col = this.cols.get(i);

            Object value = map.get(col.getDatabaseColumn());

            if ( ! col.match(value))
                throw new InvalidRowException();

            Cell cell = col.getCell();

            cell.setValue(value);

            row.addCell(cell);
        }

        // Add row to the table
        this.data.add(row);
    }

    /**
     * Sets the total rows.
     *
     * @param totalRows the new total rows
     */
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    /**
     * Sets the current rows.
     *
     * @param currentRows the new current rows
     */
    public void setCurrentRows(int currentRows) {
        this.currentRows = currentRows;
    }

    /**
     * Gets the current rows.
     *
     * @return the current rows
     */
    public int getCurrentRows() {
        return currentRows;
    }

    /**
     * Gets the total rows.
     *
     * @return the total rows
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * Gets the cols.
     *
     * @return the cols
     */
    public ArrayList<Column> getCols() {
        return this.cols;
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public ArrayList<Row> getData() {
        return this.data;
    }


    /**
     * Gets the max page.
     *
     * @return the max page
     */
    public int getMaxPage() {
        return this.strategy.getMaxPage();
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage() {
        return this.strategy.getPage();
    }

    /**
     * Navigate.
     *
     * @param page the page
     */
    public void navigate(int page) {
        this.strategy.setPage(page);

        this.fetch();

        this.update();
    }

    /**
     * Search.
     *
     * @param query the query
     */
    public void search(String query) {
        this.strategy.search(query);

        // After searching, always go to the first page and update
        this.navigate(1);
    }

    /**
     * Loaded.
     */
    public void loaded() {
        this.loaded = true;
    }

    /**
     * Checks if is loaded.
     *
     * @return true, if is loaded
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * Update.
     */
    public void update() {

        // Update view
        Platform.runLater(() -> this.view.update());

    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public TableView getView() {
        return this.view;
    }

    /**
     * Limit.
     *
     * @param limit the limit
     */
    public void limit(int limit) {
        this.strategy.setLimit(limit);
    }

    /**
     * Order by.
     *
     * @param column the column
     * @param direction the direction
     */
    public void orderBy(String column, String direction) {
        this.strategy.orderBy(column, direction);
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public int getLimit() {
        return this.strategy.getLimit();
    }

}
