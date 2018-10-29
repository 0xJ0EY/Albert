package albert.views;

import albert.controllers.PageController;
import javafx.scene.control.CheckBox;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class InvoiceDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceDetailView.fxml";
    private PageController controller;

    @FXML
    private CheckBox vink;

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
    public void onClickEdit() {
    }
}
