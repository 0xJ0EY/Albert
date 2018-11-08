package albert.views;

import albert.Client;
import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import albert.dao.ProjectDAO;
import albert.models.Contact;
import albert.models.Project;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;

import java.util.ArrayList;

public class ProjectsCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectCreateView.fxml";
    private ProjectsController controller;

    @FXML
    private TextField naam;

    @FXML
    private CheckBox isDone;

    @FXML
    private TextArea description;

    @FXML
    private ChoiceBox contactDropBox;

    @FXML
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
        this.updateContactDropdown();
    }

    private void updateContactDropdown() {
        ArrayList<Contact> contacts = this.controller.getContacts();
        this.contactDropBox.setItems(FXCollections.observableArrayList(contacts));

        if (contacts.size() > 0)
            this.contactDropBox.setValue(contacts.get(0));

    }

    @Override
    public void setController(PageController controller) {
        this.controller = (ProjectsController)controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickSave() {
        Contact contact = (Contact) this.contactDropBox.getValue();

        if (this.naam.getText().length() == 0) {
            Client.ShowWarning("Geen naam", "Er is geen projectnaam opgegeven");
            return;
        }

        Project project = new Project();
        project.setName(this.naam.getText());
        project.setContact(contact);
        project.setDescription(this.description.getText());
        project.setDone(this.isDone.isSelected());

        this.controller.createProject(project);
        this.controller.getRouter().nav("projects/");
    }

    @FXML
    public void onClickBack() {
        controller.getRouter().nav("projects/");
    }

}
