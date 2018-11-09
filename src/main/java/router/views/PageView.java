package router.views;

import albert.controllers.PageController;
import javafx.scene.layout.AnchorPane;

/**
 * The Interface PageView.
 *
 */
public interface PageView {

    /**
     * Load.
     */
    public void load();

    /**
     * Method to update the view, the view has to fetch the data from the controller
     *
     * This method has to be called before rendering the page. This should be automatically handled by the system.
     */
    public void update();

    /**
     * Sets the controller.
     *
     * @param controller the new controller
     */
    public void setController(PageController controller);

    /**
     * Render.
     *
     * @return the anchor pane
     */
    public AnchorPane render();

}
