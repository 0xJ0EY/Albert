package table.views.cells;

import config.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.cells.Cell;
import table.cells.TextCell;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;

/**
 * The Class EditableTextCellView.
 *
 */
public class EditableTextCellView extends AnchorPane implements CellView {

    /** The text field. */
    @FXML
    private TextField textField;

    /** The resource. */
    private final String resource = "/views/table/cells/EditableTextCellView.fxml";
    
    /** The controller. */
    private TextCell controller;

    /* (non-Javadoc)
     * @see table.views.CellView#load()
     */
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

    /* (non-Javadoc)
     * @see table.views.CellView#update()
     */
    @Override
    public void update() {
        Object value = this.controller.getValue();

        this.textField.setText(value != null ? value.toString() : "");
    }

    /* (non-Javadoc)
     * @see table.views.CellView#getPriority()
     */
    @Override
    public Priority getPriority() {
        return Priority.ALWAYS;
    }

    /* (non-Javadoc)
     * @see table.views.CellView#setCell(table.cells.Cell)
     */
    @Override
    public void setCell(Cell cell) {
        this.controller = (TextCell) cell;
    }

    /* (non-Javadoc)
     * @see table.views.CellView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On action.
     */
    @FXML
    private void onAction() {
        this.controller.setValue(this.textField.getText());
    }

}
