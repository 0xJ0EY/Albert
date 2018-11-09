package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import albert.models.Contact;
import albert.models.Invoice;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceEditView.
 * @author
 */
public class InvoiceEditView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/InvoiceEditView.fxml";
    
    /** The controller. */
    private InvoicesController controller;
    
    /** The dtf. */
    private SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");

    /** The hours. */
    @FXML
    private TextField hours;

    /** The price. */
    @FXML
    private TextField price;

    /** The description. */
    @FXML
    private TextField description;

    /** The betaald box. */
    @FXML
    private CheckBox betaaldBox;

    /** The linked contact. */
    @FXML
    private ComboBox linkedContact;

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

        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("invoice"));
        controller.setInvoice(invoiceId);
        this.setAttributes(controller.getInvoice());

        ArrayList<Contact> contacts = controller.getContacts();
        for(int i=0; i<contacts.size(); i++ ) {
            linkedContact.getItems().add(contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName());
            if(contacts.get(i).getId() == controller.getInvoice().getProject().getContact().getId()) {
                linkedContact.setValue(contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName());
            }
        }
    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (InvoicesController)controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click back.
     */
    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("invoices/");
    }

    /**
     * On click save.
     */
    @FXML
    public void onClickSave() {
        Date date = Date.from(deliveryDate.getValue().atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        Timestamp timeStamp = new Timestamp(date.getTime());
        int contactId = controller.getContactIdFromName(linkedContact.getValue().toString());

        controller.saveInvoice(price.getText(), hours.getText(), betaaldBox.isSelected(), timeStamp, this.controller.getInvoice(), description.getText());
        controller.getRouter().nav("invoices/");
    }

    /**
     * Sets the attributes.
     *
     * @param invoice the new attributes
     */
    public void setAttributes(Invoice invoice) {
        hours.setText(invoice.getAmount().getHours() + "");
        price.setText(invoice.getAmount().getPrice() + "");
        betaaldBox.setSelected(invoice.getPaid());
        deliveryDate.setValue(invoice.getDeliveryDate().toLocalDateTime().toLocalDate());
        description.setText(invoice.getDescription());
    }
}
