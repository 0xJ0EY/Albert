package albert.views;

import albert.controllers.PageController;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;
/*
Hier wordt de contactView geladen.
 */

public class ContactDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactDetailView.fxml";
    private PageController controller;

    @FXML
    private TextField search;


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
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickEdit() {
        controller.getRouter().nav("contacts/edit/{contact}");
    }

    @FXML
    public void onClickBack(){
        controller.getRouter().nav("contacts/");
    }
}
