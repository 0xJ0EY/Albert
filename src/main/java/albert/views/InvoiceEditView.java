package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import albert.models.Invoice;
import javafx.scene.control.CheckBox;
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
        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("invoice"));
        controller.setInvoice(invoiceId);
        this.setAttributes(controller.getInvoice());
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
        controller.saveInvoice(price.getText(), hours.getText(), betaaldBox.isSelected(), timeStamp, this.controller.getInvoice());
    }

    public void setAttributes(Invoice invoice) {
        hours.setText(invoice.getAmount().getPrice() + "");
        price.setText(invoice.getAmount().getPrice() + "");
        betaaldBox.setSelected(invoice.getPaid());
        deliveryDate.setValue(invoice.getDeliveryDate().toLocalDateTime().toLocalDate());
    }
}
