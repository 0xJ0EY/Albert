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

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectsEditView.
 * @author
 */
public class ProjectsEditView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ProjectEditView.fxml";
    
    /** The controller. */
    private ProjectsController controller;

    /** The naam. */
    @FXML
    private TextField naam;

    /** The is done. */
    @FXML
    private CheckBox isDone;

    /** The description. */
    @FXML
    private TextArea description;

    /** The contact drop box. */
    @FXML
    private ChoiceBox contactDropBox;

    /* (non-Javadoc)
     * @see router.views.PageView#load()
     */
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

    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
    @Override
    public void update() {
        this.controller.getTemplate().addAction("Terug", () -> this.onClickBack());
        this.controller.getTemplate().addAction("Opslaan", () -> this.onClickSave());

        Project project = this.controller.getProject();

        System.out.println("project = " + project);

        System.out.println("project = " + project.getName());

        System.out.println("this.naam = " + this.naam);

        this.naam.setText(project.getName());
        this.isDone.setSelected(project.getDone());
        this.description.setText(project.getDescription());
        this.updateContactDropdown();

    }

    /**
     * Update contact dropdown.
     */
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

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (ProjectsController)controller;
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

    /**
     * On click back.
     */
    @FXML
    public void onClickBack() {
        controller.getRouter().nav("projects/");
    }

}
