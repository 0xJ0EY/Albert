package table.views.tables;

import config.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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

// TODO: Auto-generated Javadoc
/**
 * The Class BaseTableView.
 * @author
 */
public abstract class BaseTableView extends AnchorPane implements TableView {

    /** The table. */
    protected Table table;
    
    /** The description content. */
    protected final String descriptionContent = Config.get("table", "text.description");

    /** The columns. */
    protected ArrayList<ColumnView> columns = new ArrayList<>();

    /** The table container. */
    @FXML
    protected ScrollPane tableContainer;

    /** The container. */
    @FXML
    protected HBox container;

    /** The pagination container. */
    @FXML
    protected HBox paginationContainer;

    /** The button container. */
    @FXML
    protected HBox buttonContainer;

    /** The description. */
    @FXML
    protected Text description;

    /** The overlay. */
    @FXML
    protected HBox overlay;

    /** The status. */
    @FXML
    protected Text status;

    /* (non-Javadoc)
     * @see table.views.TableView#load()
     */
    public abstract void load();

    /* (non-Javadoc)
     * @see table.views.TableView#update()
     */
    @Override
    public void update() {

        // Update overlay text
        this.updateOverlay();

        // Show the overlay
        this.showOverlay();

        // Scroll up
        this.scrollUp();

        // Create pagination
        this.createPagination();

        // Create buttons
        this.createButtons();

        // Create cells
        this.createColumns();

        // Update the text below
        this.updateText();

        // Create headers
        this.createHeaders();

        // Create the rows with data in the columns
        this.createRows();

        // Actually render the table to the view
        this.updateTable();

        // Hide table if the status is loaded and we have more then 0 rows
        if (this.table.isLoaded() && this.table.getTotalRows() > 0)
            this.hideOverlay();

    }

    /**
     * Scroll up.
     */
    protected void scrollUp() {
        this.tableContainer.setVvalue(0);
    }

    /**
     * Update overlay.
     */
    protected void updateOverlay() {
        String status;

        if (this.table.isLoaded()) {
            status = Config.get("table", "text.table_no_data");

        } else {
            status = Config.get("table", "text.table_loading");
        }

        this.status.setText(status);
    }

    /**
     * Show overlay.
     */
    protected void showOverlay() {
        this.overlay.setVisible(true);
    }

    /**
     * Hide overlay.
     */
    protected void hideOverlay() {
        this.overlay.setVisible(false);
    }


    /**
     * Creates the columns.
     */
    protected void createColumns() {

        this.columns = new ArrayList<>();

        int length = this.table.getCols().size();

        for (int i = 0; i < length; i++) {
            ColumnView column = new ColumnView();

            column.load();

            this.columns.add(column);
        }
    }

    /**
     * Creates the headers.
     */
    protected void createHeaders() {

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

    /**
     * Creates the rows.
     */
    protected void createRows() {

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

    /**
     * Creates the pagination.
     */
    protected void createPagination() {

        this.paginationContainer.getChildren().clear();

        this.createPreviousButton();
        this.createPageNumberButtons();
        this.createNextButton();

    }

    /**
     * Creates the previous button.
     */
    protected void createPreviousButton() {

        PreviousButton button = new PreviousButton(1, this.table.getPage(), this.table);

        this.paginationContainer.getChildren().add(button);

    }

    /**
     * Creates the page number buttons.
     */
    protected void createPageNumberButtons() {

        int minPage = 1;
        int maxPage = this.table.getMaxPage();
        int maxConfigPage = Integer.valueOf(Config.get("table", "settings.default_page_count"));

        int maxConfigSide = (int) Math.ceil((maxConfigPage - 1) / 2);

        int page = this.table.getPage();

        int left = Math.min(page - minPage, maxConfigSide);
        int right = Math.min(maxPage - page, maxConfigSide);

        int leftOffset = Math.min(left + (maxConfigSide - right), page - minPage);
        int rightOffset = Math.min(right + (maxConfigSide - left), maxPage - page);


        for (int start = page - leftOffset; start <= page + rightOffset; start++) {
            PaginationButton button = new PaginationButton(Integer.toString(start), start, this.table);

            // Add selected tag
            if (start == page)
                button.getStyleClass().add("selected");

            this.paginationContainer.getChildren().add(button);
        }

    }

    /**
     * Creates the buttons.
     */
    protected void createButtons() {
        this.buttonContainer.getChildren().clear();

        for (Button button : this.table.getButtons()) {
            this.buttonContainer.getChildren().add(button);
        }

    }

    /**
     * Creates the next button.
     */
    protected void createNextButton() {

        NextButton button = new NextButton(this.table.getMaxPage(), this.table.getPage(), this.table);

        this.paginationContainer.getChildren().add(button);

    }

    /**
     * Update text.
     */
    protected void updateText() {

        this.description.setText(
            String.format(
                this.descriptionContent,
                this.table.getCurrentRows(),
                this.table.getTotalRows()
            )
        );
    }

    /**
     * Update table.
     */
    protected void updateTable() {
        this.container.getChildren().clear();

        ArrayList<VBox> columns = new ArrayList<>();

        for (ColumnView column : this.columns) {

            VBox view = column.render();

            HBox.setHgrow(view, Priority.ALWAYS);

            columns.add(view);
        }

        this.container.getChildren().addAll(columns);
    }

    /* (non-Javadoc)
     * @see table.views.TableView#setTable(table.Table)
     */
    @Override
    public void setTable(Table table) {
        this.table = table;
    }

    /* (non-Javadoc)
     * @see table.views.TableView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }
}
