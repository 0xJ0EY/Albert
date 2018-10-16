package table.views.tables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import table.Row;
import table.Table;
import table.exceptions.ViewNotFoundException;
import table.views.RowView;
import table.views.TableView;

import java.util.ArrayList;

public class BaseTableView extends AnchorPane implements TableView {

    private final String resource = "/views/table/tables/BaseTableView.fxml";
    private Table table;

    @FXML
    private VBox rowContainer;

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
            throw new ViewNotFoundException();
        }

        this.update();
    }

    @Override
    public void update() {

        // Render rows
        for (Row row : this.table.getData()) {
            RowView rowView = row.getView();


            // Load view
            rowView.load();

            // Update view
            rowView.update();

            // Render view
            this.rowContainer.getChildren().add(row.getView().render());
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
