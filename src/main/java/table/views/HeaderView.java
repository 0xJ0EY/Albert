package table.views;

import javafx.scene.layout.AnchorPane;

// TODO: Auto-generated Javadoc
/**
 * The Interface HeaderView.
 * @author
 */
public interface HeaderView {

    /**
     * Load.
     */
    public void load();

    /**
     * Update.
     */
    public void update();

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name);

    /**
     * Render.
     *
     * @return the anchor pane
     */
    public AnchorPane render();

}
