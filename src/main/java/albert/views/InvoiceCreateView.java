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

public class InvoiceCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceCreateView.fxml";
    private InvoicesController controller;
    private Invoice invoice;
    private Amount amount;

    @FXML
    private TextField contact;

    @FXML
    private TextField hours;

    @FXML
    private TextField price;

    @FXML
    private ComboBox linkedProject;

    @FXML
    private ComboBox linkedContact;

    @FXML
    private TextField delivery;

    @FXML
    private CheckBox betaaldBox;

    @FXML
    private DatePicker deliveryDate;


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
        ArrayList<Project> projects = controller.getProjects();
        for(int i=0; i<projects.size(); i++ ) {
            linkedProject.getItems().add(projects.get(i).getName());
        }

        ArrayList<Contact> contacts = controller.getContacts();
        for(int i=0; i<contacts.size(); i++ ) {
            linkedContact.getItems().add(contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName());
        }
    }

    @Override
    public void setController(PageController controller) {
        this.controller = (InvoicesController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickSave(ActionEvent event){
        System.out.println("Click on Save");
        Date date = Date.from(deliveryDate.getValue().atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        Timestamp timeStamp = new Timestamp(date.getTime());

        controller.createInvoice(price.getText(),
                hours.getText(),
                betaaldBox.isSelected(),
                timeStamp,
                controller.getProjectIdFromName(linkedProject.getValue().toString()));

        controller.getRouter().nav("invoices/");

    }

    @FXML
    public void onClickBack(ActionEvent event) { controller.getRouter().nav("invoices/");   }
}
