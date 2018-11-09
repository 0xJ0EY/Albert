package table.views;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.cells.Cell;

/**
 * The Interface CellView.
 *
 */
public interface CellView {

    /**
     * Load.
     */
    public void load();

    /**
     * Update.
     */
    public void update();

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public Priority getPriority();

    /**
     * Sets the cell.
     *
     * @param cell the new cell
     */
    public void setCell(Cell cell);

    /**
     * Render.
     *
     * @return the anchor pane
     */
    public AnchorPane render();

}
