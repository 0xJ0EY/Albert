package table.views.tables;

import config.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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
    private final String descriptionContent = Config.get("database", "text.description");

    private ArrayList<ColumnView> columns = new ArrayList<>();

    @FXML
    private HBox container;

    @FXML
    private HBox paginationContainer;

    @FXML
    private Text description;

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

        // Create the rows with data in the columns
        this.createRows();

        // Actually render the table to the view
        this.updateTable();

        // Update the text below
        this.updateText();

        // Create pagination
        this.createPagination();

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

    private void createPagination() {

        this.createPreviousButton();
        this.createPageNumberButtons();
        this.createNextButton();

    }

    private void createPreviousButton() {

    }

    private void createPageNumberButtons() {

        int minPage = 1;
        int maxPage = this.table.getMaxPage();

        this.paginationContainer.getChildren().clear();

        for (int i = minPage; i <= maxPage; i++) {

            PaginationButton nextButton = new PaginationButton(Integer.toString(i), i, this.table);


            this.paginationContainer.getChildren().add(nextButton);
        }

    }

    private void createNextButton() {

    }

    private void updateText() {

        this.description.setText(
            String.format(
                this.descriptionContent,
                this.table.getCurrentRows(),
                this.table.getTotalRows()
            )
        );
    }

    private void updateTable() {
        this.container.getChildren().clear();

        ArrayList<VBox> columns = new ArrayList<>();

        for (ColumnView column : this.columns) {

            VBox view = column.render();

            HBox.setHgrow(view, Priority.ALWAYS);

            columns.add(view);
        }

        this.container.getChildren().addAll(columns);
    }

    @Override
    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public AnchorPane render() {
        return this;
    }
}
