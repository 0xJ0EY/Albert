package albert.views;

import albert.controllers.PageController;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class QuotationsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsEditView.fxml";
    private PageController controller;

    @FXML
    private TextField naamBar;

    @FXML
    private TextField klantBar;

    @FXML
    private TextField workBar;

    @FXML
    private TextField projectBar;


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

    @FXML
    public void onClickButton() {
        this.controller.getRouter().nav("home/");
    }
}
