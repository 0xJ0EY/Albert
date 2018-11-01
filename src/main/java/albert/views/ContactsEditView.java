package albert.views;

import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ContactsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactEditView.fxml";
    private PageController controller;

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
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }


}
