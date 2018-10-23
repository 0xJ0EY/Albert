package table;

import config.Config;
import table.exceptions.IllegalTableChangeException;
import table.exceptions.InvalidRowException;
import table.strategies.DataStrategy;
import table.views.TableView;

import java.util.ArrayList;

public class Table {

    private int amountRows = Integer.parseInt(Config.get("config", "database.default_rows"));

    private DataStrategy strategy;
    private TableView view;

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
    }

    private void setView(TableView view) {
        this.view = view;
        this.view.setTable(this);
    }

    public void setRowsAmount(int amount) {
        this.amountRows = amount;
    }

    public void fetch() {
        this.data = this.strategy.fetch(this.amountRows);
    }

    public void addCol(Column col) {
        // Do not allow changes to the tables when it already has data.
        if (this.data.size() > 0)
            throw new IllegalTableChangeException();

        this.cols.add(col);
    }

    public void addRow(Object... data) {

        // Check if the row and cells are the same size
        // Else throw an exception
        if (data.length != cols.size())
            throw new InvalidRowException();

        // Get the index for the new row, indices start at 0
        int index = this.data.size();

        // Create new row
        Row row = new Row(this);

        // Check if the row and cells have the same data type on correct key
        // Else throw an exception
        for (int i = 0; i < data.length; i++) {
            Column col = this.cols.get(i);

            if ( ! col.match(data[i]))
                throw new InvalidRowException();

            row.addCell(new Cell(col.getView(), data[i]));
        }

        // Add row to the table
        this.data.add(row);
    }

    public ArrayList<Column> getCols() {
        return this.cols;
    }

    public ArrayList<Row> getData() {
        return this.data;
    }

    public TableView getView() {

        // Fetch data
        this.fetch();

        // Load
        this.view.load();

        this.view.update();

        return this.view;
    }

}
