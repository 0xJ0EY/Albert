package table.views;

import javafx.scene.layout.AnchorPane;
import table.Table;

/**
 * The Interface TableView.
 *
 */
public interface TableView {

    /**
     * Load tableView
     */
    public void load();

    /**
     * Update tableView.
     */
    public void update();

    /**
     * Sets the table.
     *
     * @param table the new table
     */
    public void setTable(Table table);

    /**
     * Render tableView
     *
     * @return the anchor pane
     */
    public AnchorPane render();

}
