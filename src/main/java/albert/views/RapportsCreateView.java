package albert.views;

import albert.controllers.PageController;
import albert.controllers.RapportsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;

public class RapportsCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/RapportsEdit.fxml";
    private RapportsController controller;

    @FXML
    private TextField QuarterYear;

    @FXML
    private TextField nettoBar;

    @FXML
    private TextField btwBar;

    @FXML
    private TextField brutoBar;

    @FXML
    private TextField amountBar;

    @FXML
    private TextField costBar;

    @FXML
    private Button editButton;

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

    @Override
    public void update() {

    }

    @Override
    public void setController(PageController controller) {
        this.controller =(RapportsController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("reports/");
    }

    @FXML
    public void onClickSave() {

    }


}