package albert.views;

import albert.controllers.ContactController;
import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class ContactsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactEditView.fxml";
    private ContactController controller;
    ArrayList<String> emails;

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
        } catch (Exception ex) {
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

    public void onClickSave(){
        emails = new ArrayList<String>();
        emails.add(email.getText());
        controller.saveContact(firstName.getText(), lastName.getText(),houseNumber.getText(),telephone.getText(),postcode.getText(),emails ,website.getText(),description.getText(),streetName.getText(),place.getText());
    }

    @FXML
    public void onClickBack(){
        controller.getRouter().nav("contacts/1");
    }

}
