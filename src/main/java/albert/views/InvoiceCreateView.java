package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import albert.models.Amount;
import albert.models.Contact;
import albert.models.Invoice;
import albert.models.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceCreateView.
 * @author
 */
public class InvoiceCreateView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/InvoiceCreateView.fxml";
    
    /** The controller. */
    private InvoicesController controller;
    
    /** The invoice. */
    private Invoice invoice;
    
    /** The amount. */
    private Amount amount;

    /** The contact. */
    @FXML
    private TextField contact;

    /** The hours. */
    @FXML
    private TextField hours;

    /** The price. */
    @FXML
    private TextField price;

    /** The linked project. */
    @FXML
    private ComboBox linkedProject;

    /** The linked contact. */
    @FXML
    private ComboBox linkedContact;

    /** The description. */
    @FXML
    private TextField description;

    /** The paid box. */
    @FXML
    private CheckBox paidBox;

    /** The delivery date. */
    @FXML
    private DatePicker deliveryDate;


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

        ArrayList<Project> projects = controller.getProjects();
        for(int i=0; i<projects.size(); i++ ) {
            linkedProject.getItems().add(projects.get(i).getName());
        }

        ArrayList<Contact> contacts = controller.getContacts();
        for(int i=0; i<contacts.size(); i++ ) {
            linkedContact.getItems().add(contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName());
        }
    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (InvoicesController) controller;
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
        System.out.println("Click on Save");
        Date date = Date.from(deliveryDate.getValue().atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        Timestamp timeStamp = new Timestamp(date.getTime());

        int projectId = controller.getProjectIdFromName(linkedProject.getValue().toString());

        controller.createInvoice(price.getText(),
            hours.getText(),
            paidBox.isSelected(),
            timeStamp,
            projectId,
            description.getText(),
            linkedContact.getValue().toString()
        );

        controller.getRouter().nav("invoices/");

    }

    /**
     * On click back.
     */
    @FXML
    public void onClickBack() { controller.getRouter().nav("invoices/");   }
}
