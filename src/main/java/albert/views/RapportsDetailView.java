package albert.views;

import albert.controllers.PageController;
import albert.controllers.RapportsController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class RapportsDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/RapportsDetail.fxml";
    private RapportsController controller;

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

    public void onClickGeneratePdf(){

    }
}
