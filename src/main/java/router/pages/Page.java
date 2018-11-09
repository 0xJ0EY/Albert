package router.pages;

import router.templates.TemplateController;
import router.views.PageView;
import router.Router;


/**
 * The Interface Page. Creates an Page
 *
 */
public interface Page {

    /**
     * Gets the template.
     *
     * @return the template
     */
    public TemplateController getTemplate();

    /**
     * Sets the router.
     *
     * @param router the new router
     */
    public void setRouter(Router router);

    /**
     * Gets the router.
     *
     * @return the router
     */
    public Router getRouter();

    /**
     * Gets the view.
     *
     * @return the view
     */
    public PageView getView();

}
