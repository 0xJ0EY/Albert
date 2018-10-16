package albert.views.pages;

import albert.controllers.PageController;
import albert.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ContactView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactView.fxml";
    private PageController controller;

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
    public void setController(PageController controller) {
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickButton() {

        this.controller.getRouter().nav("projects/details/1/");

    }
}
