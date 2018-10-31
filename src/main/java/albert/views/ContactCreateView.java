package albert.views;

import albert.controllers.ContactController;
import albert.controllers.PageController;
import albert.models.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import router.views.PageView;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;

public class ContactCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactCreateView.fxml";
    private ContactController controller;

    private Contact contact;

    @FXML
    private TextField firstName;

    @FXML
    private Button saveButton;

    @FXML
    private TextField lastName;

    @FXML
    private TextField streetName;

    @FXML
    private TextField compagny;

    @FXML
    private TextField houseNumber;

    @FXML
    private TextField postcode;

    @FXML
    private TextField place;

    @FXML
    private TextField website;

    @FXML
    private TextField description;

    @FXML
    private TextField telephone;

    @FXML
    private TextField email;

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
        this.controller = (ContactController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void clickOnSave(ActionEvent event){

        System.out.println("Click on Save");
        controller.saveContact(firstName.getText(), lastName.getText(),houseNumber.getText(),telephone.getText(),postcode.getText(), email.getText(),website.getText(),description.getText(),streetName.getText(),place.getText());
    }
}
