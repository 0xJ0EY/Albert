package table.views.column;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import table.Column;
import table.exceptions.ViewNotFoundException;

/**
 * The Class ColumnView.
 *
 */
public class ColumnView extends VBox {

    /** The resource. */
    private final String resource = "/views/table/columns/ColumnView.fxml";
    
    /** The cell. */
    private Column cell;

    /**
     * Load.
     */
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

    /**
     * Sets the cell.
     *
     * @param cell the new cell
     */
    public void setCell(Column cell) {
        this.cell = cell;
    }

    /**
     * Update.
     */
    public void update() {

        // TODO: Refactor
        HBox.setHgrow(this, this.cell.getCell().getView().getPriority());

    }

    /**
     * Render.
     *
     * @return the v box
     */
    public VBox render() {
        return this;
    }
}
