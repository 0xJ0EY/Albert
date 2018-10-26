package router.views;

import albert.controllers.PageController;
import javafx.scene.layout.AnchorPane;

public interface PageView {

    public void load();

    /**
     * Method to update the view, the view has to fetch the data from the controller
     *
     * This method has to be called before rendering the page. This should be automatically handled by the system.
     */
    public void update();

    public void setController(PageController controller);

    public AnchorPane render();

}
