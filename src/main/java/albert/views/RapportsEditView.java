package albert.views;

import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class RapportsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/RapportEditView.fxml";
    private PageController controller;

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
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }


}
