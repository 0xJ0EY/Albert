package router.templates;

import albert.controllers.PageController;
import javafx.scene.Parent;
import router.Router;
import router.action.TemplateAction;
import router.pages.Page;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Interface TemplateController.
 *
 */
public interface TemplateController {

    /**
     * Sets the page.
     *
     * @param page the new page
     */
    public void setPage(PageController page);

    /**
     * Gets the page.
     *
     * @return the page
     */
    public PageController getPage();

    /**
     * Render.
     *
     * @return the parent
     */
    public Parent render();

    /**
     * Gets the router.
     *
     * @return the router
     */
    public Router getRouter();

    /**
     * Adds the action.
     *
     * @param name the name
     * @param templateAction the template action
     */
    public void addAction(String name, TemplateAction templateAction);

    /**
     * Gets the actions.
     *
     * @return the actions
     */
    public HashMap<String, TemplateAction> getActions();

}
