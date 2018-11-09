package albert.views;

import albert.controllers.PageController;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * The Class SettingsEditView. Loads the view SettingsEditView
 *
 */
public class SettingsEditView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/SettingsEditView.fxml";
    
    /** The controller. */
    private PageController controller;

    /* (non-Javadoc)
     * @see router.views.PageView#load()
     */
    @Override
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

    /**
     * On click button.
     */
    @FXML
    public void onClickButton() {
        this.controller.getRouter().nav("home/");
    }
}
