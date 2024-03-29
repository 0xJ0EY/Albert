package router.error_pages.views;

import albert.controllers.PageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;


/**
 * The Class NotFoundView. Shows an errorView
 *
 */
public class NotFoundView extends AnchorPane implements PageView {
    
    /** The resource. */
    private final String resource = "/views/error_pages/PageNotFound.fxml";
    
    /** The controller. */
    private PageController controller;

    /* (non-Javadoc)
     * @see router.views.PageView#load()
     */
    @Override
    /**
     * Creates an pagenotfound if its goes wrong
     */

    public void load() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
    @Override
    public void update() {

    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

}
