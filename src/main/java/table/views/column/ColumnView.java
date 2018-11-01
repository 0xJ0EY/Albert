package table.views.column;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import table.Column;
import table.exceptions.ViewNotFoundException;

public class ColumnView extends VBox {

    private final String resource = "/views/table/columns/ColumnView.fxml";
    private Column cell;

    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            throw new ViewNotFoundException();
        }
    }

    public void setCell(Column cell) {
        this.cell = cell;
    }

    public void update() {

        HBox.setHgrow(this, this.cell.getView().getPriority());

    }

    public VBox render() {
        return this;
    }
}
