package table.views.cells;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.Cell;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;

public class TextCellView extends AnchorPane implements CellView<String> {

    @FXML
    private Label label;

    private final String resource = "/views/table/cells/TextCellView.fxml";
    private Cell value;

    @Override
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

    @Override
    public void update() {
        String name = this.value.getObject().toString();

        this.label.setText(name);
    }

    @Override
    public Priority getPriority() {
        return Priority.ALWAYS;
    }

    @Override
    public void setCell(Cell cell) {
        this.value = cell;
    }

    @Override
    public boolean match(Object object) {
        return true;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

}
