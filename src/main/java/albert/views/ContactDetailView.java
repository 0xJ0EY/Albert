package albert.views;

import albert.controllers.ContactController;
import albert.controllers.PageController;
import albert.models.Contact;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import table.Table;
import java.io.IOException;
/*
Hier wordt de contactView geladen.
 */

public class ContactDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactDetailView.fxml";
    private ContactController controller;

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

        this.firstName.setText(contact.getFirstName());
        this.lastName.setText(contact.getLastName());
        this.company.setText(contact.getCompany());
        this.streetName.setText(contact.getStreetName());
        this.houseNumber.setText(contact.getHouseNumber());
        this.place.setText(contact.getCity());
        this.postcode.setText(contact.getPostalCode());
        this.website.setText(contact.getWebsite());
        this.description.setText(contact.getDescription());

        this.setupEmailTable();
        this.setupPhoneNumberTable();
    }

    @Override
    public void setController(PageController controller) {
        this.controller = (ContactController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
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

    @FXML
    public void onClickEdit() {
        controller.getRouter().nav("contacts/edit/" + this.controller.getContact().getId());
    }

    @FXML
    public void onClickBack(){
        controller.getRouter().nav("contacts/");
    }
}
