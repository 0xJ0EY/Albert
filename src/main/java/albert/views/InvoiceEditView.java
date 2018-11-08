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

public class InvoiceEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceEditView.fxml";
    private InvoicesController controller;
    private SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");

    @FXML
    private TextField hours;

    @FXML
    private TextField price;

    @FXML
    private TextField description;

    @FXML
    private CheckBox betaaldBox;

    @FXML
    private ComboBox linkedContact;

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

    @Override
    public void setController(PageController controller) {
        this.controller = (InvoicesController)controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("invoices/");
    }

    @FXML
    public void onClickSave() {
        Date date = Date.from(deliveryDate.getValue().atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        Timestamp timeStamp = new Timestamp(date.getTime());
        int contactId = controller.getContactIdFromName(linkedContact.getValue().toString());

        controller.saveInvoice(price.getText(), hours.getText(), betaaldBox.isSelected(), timeStamp, this.controller.getInvoice(), description.getText());
        controller.getRouter().nav("invoices/");
    }

    public void setAttributes(Invoice invoice) {
        hours.setText(invoice.getAmount().getHours() + "");
        price.setText(invoice.getAmount().getPrice() + "");
        betaaldBox.setSelected(invoice.getPaid());
        deliveryDate.setValue(invoice.getDeliveryDate().toLocalDateTime().toLocalDate());
        description.setText(invoice.getDescription());
    }
}
