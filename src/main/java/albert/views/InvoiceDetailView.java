package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import albert.models.Invoice;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InvoiceDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceDetailView.fxml";
    private InvoicesController controller;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @FXML
    private CheckBox paidBox;

    @FXML
    private Text invoiceId;

    @FXML
    private Text date;

    @FXML
    private Text hours;

    @FXML
    private Text btwPercentage;

    @FXML
    private Text project;

    @FXML
    private Text bAmount;

    @FXML
    private Text nAmount;

    @FXML
    private Text naamKlant;

    @FXML
    private Text description;



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
        this.controller.getTemplate().addAction("Genereer PDF", () -> {
            try {
                this.onClickGeneratePdf();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        this.controller.getTemplate().addAction("Factuur aanpassen", () -> this.onClickEdit());

        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("invoice"));
        controller.setInvoice(invoiceId);
        this.setAttributes(controller.getInvoice());
    }

    @Override
    public void setController(PageController controller) {
        this.controller = (InvoicesController)controller;
    }

    @Override
    public AnchorPane render() { return this; }

    @FXML
    public void onClickEdit() {
        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("invoice"));
        controller.getRouter().nav("invoices/edit/" + invoiceId);
    }

    @FXML
    public void onClickGeneratePdf() throws ParseException {
        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("invoice"));
        controller.setInvoice(invoiceId);
        controller.getInvoice().generatePdf();
    }

    @FXML
    public void onClickBack() {
        controller.getRouter().nav("invoices/");
    }

    public void setAttributes(Invoice invoice) {
        naamKlant.setText(controller.getContactNameFromId(invoice.getProject().getContact().getId()));
        paidBox.setSelected(invoice.getPaid());
        invoiceId.setText("" + invoice.getId());
        date.setText(dateFormat.format(invoice.getDeliveryDate()));
        hours.setText("" + invoice.getAmount().getHours());
        btwPercentage.setText("" + invoice.getTax().getPercentage() + "%");
        project.setText(invoice.getProject().getName());
        bAmount.setText(String.valueOf(invoice.getAmount().getPrice()));
        nAmount.setText(String.valueOf(invoice.getAmount().getPrice() + invoice.calculateTax()));
        description.setText(invoice.getDescription());
    }
}
