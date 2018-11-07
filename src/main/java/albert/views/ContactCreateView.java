package albert.views;

import albert.Client;
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
import table.Table;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

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
    private TextField company;

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


    @FXML
    private AnchorPane emailsTable;

    @FXML
    private AnchorPane phoneNumberTable;

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
        Contact contact = this.controller.getContact();

        this.setupEmailTable();
        this.setupPhoneNumberTable();

    }

    private void setupEmailTable() {

        Table emailsTable = this.controller.getEmailsTable();

        emailsTable.fetch();

        emailsTable.update();

        AnchorPane emailsView = emailsTable.getView().render();

        AnchorPane.setRightAnchor(emailsView, 0.0);
        AnchorPane.setLeftAnchor(emailsView, 0.0);
        AnchorPane.setTopAnchor(emailsView, 0.0);
        AnchorPane.setBottomAnchor(emailsView, 0.0);

        this.emailsTable.getChildren().add(emailsView);

    }

    private void setupPhoneNumberTable() {

        Table phoneNumbersTable = this.controller.getPhoneNumbersTable();

        phoneNumbersTable.fetch();

        phoneNumbersTable.update();

        AnchorPane phoneNumberView = phoneNumbersTable.getView().render();

        AnchorPane.setRightAnchor(phoneNumberView, 0.0);
        AnchorPane.setLeftAnchor(phoneNumberView, 0.0);
        AnchorPane.setTopAnchor(phoneNumberView, 0.0);
        AnchorPane.setBottomAnchor(phoneNumberView, 0.0);

        this.phoneNumberTable.getChildren().add(phoneNumberView);

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
    public void onClickSave(){
        Contact contact = this.controller.getContact();

        if (this.firstName.getText().length() == 0) {
            Client.ShowWarning("Geen naam", "Er is geen voornaam opgegeven");
            return;
        }

        if (this.lastName.getText().length() == 0) {
            Client.ShowWarning("Geen naam", "Er is geen achternaam opgegeven");
            return;
        }

        contact.setFirstName(this.firstName.getText());
        contact.setLastName(this.lastName.getText());
        contact.setCompany(this.company.getText());
        contact.setStreetName(this.streetName.getText());
        contact.setHouseNumber(this.houseNumber.getText());
        contact.setPostalCode(this.postcode.getText());
        contact.setCity(this.place.getText());
        contact.setWebsite(this.website.getText());
        contact.setDescription(this.description.getText());

        this.controller.createContact(contact);
        this.controller.getRouter().nav("contacts/");
    }

    @FXML
    public void onClickBack(){ controller.getRouter().nav("contacts/"); }
}
