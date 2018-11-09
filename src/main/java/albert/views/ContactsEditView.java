package albert.views;

import albert.Client;
import albert.controllers.ContactController;
import albert.controllers.PageController;
import albert.models.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import table.Row;
import table.Table;
import table.views.TableView;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * The Class ContactsEditView. Loads the ContactsEditView
 *
 */
public class ContactsEditView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ContactEditView.fxml";
    
    /** The controller. */
    private ContactController controller;

    /** The first name. */
    @FXML
    private TextField firstName;

    /** The save button. */
    @FXML
    private Button saveButton;

    /** The last name. */
    @FXML
    private TextField lastName;

    /** The company. */
    @FXML
    private TextField company;

    /** The street name. */
    @FXML
    private TextField streetName;

    /** The house number. */
    @FXML
    private TextField houseNumber;

    /** The postcode. */
    @FXML
    private TextField postcode;

    /** The place. */
    @FXML
    private TextField place;

    /** The website. */
    @FXML
    private TextField website;

    /** The description. */
    @FXML
    private TextField description;

    /** The telephone. */
    @FXML
    private TextField telephone;

    /** The email. */
    @FXML
    private TextField email;

    /** The emails table. */
    @FXML
    private AnchorPane emailsTable;

    /** The phone number table. */
    @FXML
    private AnchorPane phoneNumberTable;

    /* (non-Javadoc)
     * @see router.views.PageView#load()
     */
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

    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
    @Override
    public void update() {
        this.controller.getTemplate().addAction("Terug", () -> this.onClickBack());
        this.controller.getTemplate().addAction("Opslaan", () -> this.onClickSave());

        Contact contact = this.controller.getContact();

        this.firstName.setText(contact.getFirstName());
        this.lastName.setText(contact.getLastName());
        this.company.setText(contact.getCompany());
        this.streetName.setText(contact.getStreetName());
        this.houseNumber.setText(contact.getHouseNumber());
        this.postcode.setText(contact.getPostalCode());
        this.place.setText(contact.getCity());
        this.website.setText(contact.getWebsite());
        this.description.setText(contact.getDescription());

        this.setupEmailTable();
        this.setupPhoneNumberTable();

    }

    /**
     * Setup email table.
     */
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

    /**
     * Setup phone number table.
     */
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

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (ContactController) controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click save.
     */
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

        this.controller.updateContact(contact);
        this.controller.getRouter().nav("contacts/");
    }

    /**
     * On click back.
     */
    @FXML
    public void onClickBack(){ controller.getRouter().nav("contacts/"); }

}
