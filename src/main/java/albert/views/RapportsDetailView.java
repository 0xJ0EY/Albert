package albert.views;

import albert.controllers.PageController;
import albert.controllers.RapportsController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * The Class RapportsDetailView. Loads the RapportsDetailView
 *
 */
public class RapportsDetailView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/RapportsDetail.fxml";
    
    /** The controller. */
    private RapportsController controller;

    /** The edit button. */
    @FXML
    private Button editButton;

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
        this.controller =(RapportsController) controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click back.
     */
    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("reports/");
    }

    /**
     * On click save.
     */
    @FXML
    public void onClickSave() {

    }

    /**
     * On click generate pdf.
     */
    public void onClickGeneratePdf(){

    }
}
