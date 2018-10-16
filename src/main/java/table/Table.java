package table;

import table.exceptions.IllegalTableChangeException;
import table.exceptions.InvalidRowException;
import table.factories.rows.RowViewFactory;
import table.strategies.DataStrategy;
import table.views.RowView;
import table.views.TableView;

import java.util.ArrayList;

public class Table {

    private DataStrategy strategy;
    private TableView view;
    private RowViewFactory rowViewFactory;

    private ArrayList<Column> cols = new ArrayList<Column>();
    private ArrayList<Row> data = new ArrayList<Row>();

    public Table(DataStrategy strategy, TableView view, RowViewFactory rowViewFactory) {
        this.setStrategy(strategy);
        this.setView(view);
        this.rowViewFactory = rowViewFactory;
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
    }

    public void fetch() {
        this.data = this.strategy.fetch();
    }

    public void addCol(Column col) {
        // Do not allow changes to the tables when it already has data.
        if (this.data.size() > 0)
            throw new IllegalTableChangeException();

        this.cols.add(col);
    }

    public void addRow(Row row) {
        Object[] data = row.getData();

        // Check if the row and columns are the same size
        // Else throw an exception
        if (data.length != cols.size())
            throw new InvalidRowException();

        // Check if the row and columns have the same data type on correct key
        // Else throw an exception
        for (int i = 0; i < data.length; i++) {
            Column col = this.cols.get(i);

            if ( ! col.match(data[i]))
                throw new InvalidRowException();
        }

        // Set index
        row.setIndex(this.data.size());

        // Append selected view
        row.setView(this.rowViewFactory.create());

        // Append current table
        row.setTable(this);

        // Add row to the dataset
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
//        this.fetch();

        // Load
        this.view.load();

        return this.view;
    }

}
