package table.views.tables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import table.Column;
import table.Row;
import table.Table;
import table.Cell;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;
import table.views.HeaderView;
import table.views.TableView;
import table.views.column.ColumnView;

import java.util.ArrayList;

public class BaseTableView extends AnchorPane implements TableView {

    private final String resource = "/views/table/tables/BaseTableView.fxml";
    private Table table;

    private ArrayList<ColumnView> columns;

    @FXML
    private HBox container;

    @FXML
    private HBox paginationContainer;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ViewNotFoundException();
        }

    }

    @Override
    public void update() {

        // Create cells
        this.createColumns();

        // Create headers
        this.createHeaders();

        // Render rows to the columns
        this.createRows();

    }


    private void createColumns() {

        this.columns = new ArrayList<>();

        int length = this.table.getCols().size();

        for (int i = 0; i < length; i++) {
            ColumnView column = new ColumnView();

            column.load();

            this.columns.add(column);
        }
    }

    private void createHeaders() {

        ArrayList<Column> cols = this.table.getCols();

        int index = 0;

        for (Column col : cols) {

            System.out.println("index = " + index);
            
            HeaderView view = col.getHeaderView();

            view.load();

            view.update();

            AnchorPane pane = view.render();

            pane.getStyleClass().add("header");

            this.columns.get(index).getChildren().add(pane);

            index++;
        }

    }

    private void createRows() {

        // Based on a row
        ArrayList<Row> rows = this.table.getData();

        int rowIndex = 0;

        // For every row, render the cols to the same index
        for (Row row : rows) {

            int colIndex = 0;

            ArrayList<Cell> values = row.getCells();

            for (Cell value : values) {

                CellView view = value.getView();

                view.load();

                view.update();

                AnchorPane pane = view.render();

                pane.getStyleClass().add(rowIndex % 2 == 0 ? "even" : "odd");

                this.columns.get(colIndex).getChildren().add(view.render());

                colIndex++;
            }

            rowIndex++;
        }
    }

    @Override
    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public AnchorPane render() {

        this.container.getChildren().clear();

        ArrayList<VBox> columns = new ArrayList<>();

        for (ColumnView column : this.columns) {

            VBox view = column.render();

            HBox.setHgrow(view, Priority.ALWAYS);

            columns.add(view);
        }

        this.container.getChildren().addAll(columns);

        return this;
    }
}
