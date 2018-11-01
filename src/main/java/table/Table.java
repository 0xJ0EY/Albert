package table;

import config.Config;
import table.cells.Cell;
import table.exceptions.IllegalTableChangeException;
import table.exceptions.InvalidRowException;
import table.strategies.DataStrategy;
import table.views.TableView;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {

    private int amountRows = Integer.parseInt(Config.get("table", "settings.default_rows"));

    private DataStrategy strategy;
    private TableView view;

    private int currentRows = 0;
    private int totalRows = 0;

    private ArrayList<Column> cols = new ArrayList<Column>();
    private ArrayList<Row> data = new ArrayList<Row>();

    public Table(DataStrategy strategy, TableView view) {
        this.setStrategy(strategy);
        this.setView(view);
    }

    private void setStrategy(DataStrategy strategy) {
        // Do not allow changes to the tables when it already has data.
        if (this.data.size() > 0)
            throw new IllegalTableChangeException();

        this.strategy = strategy;
        this.strategy.setTable(this);
    }

    private void setView(TableView view) {
        this.view = view;
        this.view.setTable(this);
        this.view.load();
    }

    public void setRowsAmount(int amount) {
        this.amountRows = amount;
    }

    public void fetch() {
        // Clear old data set
        this.data = new ArrayList<>();

        // Fetch new data set
        this.strategy.fetch();
    }

    public void addCol(Column col) {
        // Do not allow changes to the tables when it already has data.
        if (this.data.size() > 0)
            throw new IllegalTableChangeException();

        this.cols.add(col);
    }

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

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setCurrentRows(int currentRows) {
        this.currentRows = currentRows;
    }

    public int getCurrentRows() {
        return currentRows;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public ArrayList<Column> getCols() {
        return this.cols;
    }

    public ArrayList<Row> getData() {
        return this.data;
    }


    public int getMaxPage() {
        return this.strategy.getMaxPage();
    }

    public int getPage() {
        return this.strategy.getPage();
    }

    public void navigate(int page) {
        this.strategy.setPage(page);
        this.update();
    }

    public void search(String query) {
        this.strategy.search(query);

        // After searching, always go to the first page and update
        this.navigate(1);
    }

    public void update() {

        // Fetch data
        this.fetch();

        // Update view
        this.view.update();

    }

    public TableView getView() {
        return this.view;
    }

}
