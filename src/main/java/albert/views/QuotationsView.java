package albert.views;

import albert.controllers.PageController;
import albert.controllers.QuotationsController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class QuotationsView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsView.fxml";
    private QuotationsController controller;

    @FXML
    private TextField searchBar;

    @FXML
    private Button pdfButton;

    @FXML
    private Button editButton;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void setController(PageController controller) {
        this.controller =(QuotationsController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickAddQuotation() {

        this.controller.getRouter().nav("quotations/edit/{quotation}/");

    }

}
