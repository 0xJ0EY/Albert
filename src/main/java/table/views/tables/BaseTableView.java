package table.views.tables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import table.Column;
import table.Row;
import table.Table;
import table.exceptions.ViewNotFoundException;
import table.views.ColumnView;
import table.views.TableView;

import java.util.ArrayList;

public class BaseTableView extends AnchorPane implements TableView {

    private final String resource = "/views/table/tables/BaseTableView.fxml";
    private Table table;

    @FXML
    private GridPane rowContainer;

    @FXML
    private HBox paginationContainer;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        System.out.println("loader = " + loader);

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ViewNotFoundException();
        }

        this.update();
    }

    @Override
    public void update() {

        int rowIndex = 0;
        int colIndex;

        // Create table constraints
        for (Column column : this.table.getCols()) {
            ColumnView view = column.getView();

            Pane pane = view.render();

            ColumnConstraints constraint = new ColumnConstraints(
                pane.getMinWidth(),
                pane.getPrefWidth(),
                pane.getMaxWidth()
            );

            constraint.setHgrow(view.getPriority());

            this.rowContainer.getColumnConstraints().add(constraint);
        }

        // Render rows
        for (Row row : this.table.getData()) {
            ArrayList<ColumnView> columns = row.getColumns();

            colIndex = 0;

            // Render columns
            for (ColumnView column : columns) {

                Pane pane = column.render();

                GridPane.setHalignment(pane, column.getHPos());

                this.rowContainer.add(pane, colIndex, rowIndex);

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
        return this;
    }
}
