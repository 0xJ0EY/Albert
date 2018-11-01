package table.views.tables;

import config.Config;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import table.Column;
import table.Row;
import table.Table;
import table.cells.Cell;
import table.views.CellView;
import table.views.HeaderView;
import table.views.TableView;
import table.views.column.ColumnView;
import table.views.tables.components.NextButton;
import table.views.tables.components.PaginationButton;
import table.views.tables.components.PreviousButton;

import java.util.ArrayList;

public abstract class BaseTableView extends AnchorPane implements TableView {

    protected Table table;
    protected final String descriptionContent = Config.get("table", "text.description");

    protected ArrayList<ColumnView> columns = new ArrayList<>();

    @FXML
    protected HBox container;

    @FXML
    protected HBox paginationContainer;

    @FXML
    protected Text description;

    public abstract void load();

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

            for (Cell cell : values) {

                CellView view = cell.getView();

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

        this.paginationContainer.getChildren().clear();

        this.createPreviousButton();
        this.createPageNumberButtons();
        this.createNextButton();

    }

    private void createPreviousButton() {


        PreviousButton button = new PreviousButton(1, this.table.getPage(), this.table);

        this.paginationContainer.getChildren().add(button);


    }

    private void createPageNumberButtons() {

        int minPage = 1;
        int maxPage = this.table.getMaxPage();
        int maxConfigPage = Integer.valueOf(Config.get("table", "settings.default_page_count"));

        int maxConfigSide = (int) Math.ceil((maxConfigPage - 1) / 2);

        int page = this.table.getPage();

        int left = Math.min(page - minPage, maxConfigSide);
        int right = Math.min(maxPage - page, maxConfigSide);

        int leftOffset = left + (maxConfigSide - right);
        int rightOffset = right + (maxConfigSide - left);

        for (int start = page - leftOffset; start <= page + rightOffset; start++) {
            PaginationButton button = new PaginationButton(Integer.toString(start), start, this.table);

            // Add selected tag
            if (start == page)
                button.getStyleClass().add("selected");

            this.paginationContainer.getChildren().add(button);
        }

    }

    private void createNextButton() {

        NextButton button = new NextButton(this.table.getMaxPage(), this.table.getPage(), this.table);

        this.paginationContainer.getChildren().add(button);

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
