package table.views.cells;

import config.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.cells.Cell;
import table.cells.RouteCell;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;

// TODO: Auto-generated Javadoc
/**
 * The Class EditCellView.
 * @author
 */
public class EditCellView extends AnchorPane implements CellView {

    /** The resource. */
    private final String resource = "/views/table/cells/EditCellView.fxml";
    
    /** The controller. */
    private RouteCell controller;

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
    public void update() { }

    /* (non-Javadoc)
     * @see table.views.CellView#getPriority()
     */
    @Override
    public Priority getPriority() {
        return Priority.NEVER;
    }

    /* (non-Javadoc)
     * @see table.views.CellView#setCell(table.cells.Cell)
     */
    @Override
    public void setCell(Cell cell) {
        this.controller = (RouteCell) cell;
    }

    /* (non-Javadoc)
     * @see table.views.CellView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click cell.
     */
    @FXML
    public void onClickCell() {
        this.controller.nav();
    }

}
