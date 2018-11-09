package albert.views;

import albert.controllers.PageController;
import albert.controllers.RapportsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;

/**
 * The Class RapportsCreateView. Loads the RapportsCreateView
 *
 */
public class RapportsCreateView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/RapportsEdit.fxml";
    
    /** The controller. */
    private RapportsController controller;

    /** The Quarter year. */
    @FXML
    private TextField QuarterYear;

    /** The netto bar. */
    @FXML
    private TextField nettoBar;

    /** The btw bar. */
    @FXML
    private TextField btwBar;

    /** The bruto bar. */
    @FXML
    private TextField brutoBar;

    /** The amount bar. */
    @FXML
    private TextField amountBar;

    /** The cost bar. */
    @FXML
    private TextField costBar;

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


}
