package albert.views;

import albert.Client;
import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import albert.dao.ProjectDAO;
import albert.models.Contact;
import albert.models.Project;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class ProjectsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectEditView.fxml";
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

        Project project = this.controller.getProject();

        this.naam.setText(project.getName());
        this.isDone.setSelected(project.getDone());
        this.description.setText(project.getDescription());
        this.updateContactDropdown();

    }

    private void updateContactDropdown() {
        ArrayList<Contact> contacts = this.controller.getContacts();

        Contact selected = null;
        Contact projectContact = this.controller.getProject().getContact();

        for (Contact contact : contacts) {
            if (contact.getId() == projectContact.getId())
                selected = contact;
        }

        this.contactDropBox.setItems(FXCollections.observableArrayList(contacts));
        this.contactDropBox.setValue(selected);
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

        Project project = controller.getProject();

        project.setName(this.naam.getText());
        project.setContact(contact);
        project.setDescription(this.description.getText());
        project.setDone(this.isDone.isSelected());

        this.controller.updateProject(project);
        this.controller.getRouter().nav("projects/");

    }

    @FXML
    public void onClickBack() {
        controller.getRouter().nav("projects/");
    }

}
