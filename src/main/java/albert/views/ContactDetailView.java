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


/**
 * The Class ContactDetailView. Loads the Contactdetailview
 *
 */
public class ContactDetailView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ContactDetailView.fxml";
    
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
    @Override
    public void update() {
        this.controller.getTemplate().addAction("Terug", () -> this.onClickBack());
        this.controller.getTemplate().addAction("Opslaan", () -> this.onClickEdit());

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

    /**
     * On click edit.
     */
    @FXML
    public void onClickEdit() {
        controller.getRouter().nav("contacts/edit/" + this.controller.getContact().getId());
    }

    /**
     * On click back.
     */
    @FXML
    public void onClickBack(){
        controller.getRouter().nav("contacts/");
    }
}
