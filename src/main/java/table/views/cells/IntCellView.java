package table.views.cells;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.cells.Cell;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;

public class IntCellView extends AnchorPane implements CellView<Integer> {

    @FXML
    private Label label;

    private final String resource = "/views/table/cells/IntCellView.fxml";
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
        String value =  this.value.getValue().toString();

        label.setText(value);
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
        return object.getClass() == Integer.class;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

}
