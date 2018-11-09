package router.views;

import albert.controllers.PageController;
import router.templates.TemplateController;
import javafx.scene.Parent;

// TODO: Auto-generated Javadoc
/**
 * The Interface TemplateView.
 * @author
 */
public interface TemplateView {

    /**
     * Load.
     */
    public void load();

    /**
     * Update.
     */
    public void update();

    /**
     * Sets the controller.
     *
     * @param controller the new controller
     */
    public void setController(TemplateController controller);

    /**
     * Render.
     *
     * @return the parent
     */
    public Parent render();

}
