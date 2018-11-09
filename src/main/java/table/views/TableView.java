package table.views;

import javafx.scene.layout.AnchorPane;
import table.Table;

// TODO: Auto-generated Javadoc
/**
 * The Interface TableView.
 * @author
 */
public interface TableView {

    /**
     * Load.
     */
    public void load();

    /**
     * Update.
     */
    public void update();

    /**
     * Sets the table.
     *
     * @param table the new table
     */
    public void setTable(Table table);

    /**
     * Render.
     *
     * @return the anchor pane
     */
    public AnchorPane render();

}
