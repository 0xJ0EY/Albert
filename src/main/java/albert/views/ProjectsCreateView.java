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

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectsCreateView.
 * @author
 */
public class ProjectsCreateView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ProjectCreateView.fxml";
    
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

        this.updateContactDropdown();
    }

    /**
     * Update contact dropdown.
     */
    private void updateContactDropdown() {
        ArrayList<Contact> contacts = this.controller.getContacts();
        this.contactDropBox.setItems(FXCollections.observableArrayList(contacts));

        if (contacts.size() > 0)
            this.contactDropBox.setValue(contacts.get(0));

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

        Project project = new Project();
        project.setName(this.naam.getText());
        project.setContact(contact);
        project.setDescription(this.description.getText());
        project.setDone(this.isDone.isSelected());

        this.controller.createProject(project);
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
