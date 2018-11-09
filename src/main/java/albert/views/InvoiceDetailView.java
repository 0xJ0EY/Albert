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

/**
 * The Class InvoiceDetailView. Loads the InvoiceDetailView
 *
 */
public class InvoiceDetailView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/InvoiceDetailView.fxml";
    
    /** The controller. */
    private InvoicesController controller;
    
    /** The date format. */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /** The paid box. */
    @FXML
    private CheckBox paidBox;

    /** The invoice id. */
    @FXML
    private Text invoiceId;

    /** The date. */
    @FXML
    private Text date;

    /** The hours. */
    @FXML
    private Text hours;

    /** The btw percentage. */
    @FXML
    private Text btwPercentage;

    /** The project. */
    @FXML
    private Text project;

    /** The b amount. */
    @FXML
    private Text bAmount;

    /** The n amount. */
    @FXML
    private Text nAmount;

    /** The naam klant. */
    @FXML
    private Text naamKlant;

    /** The description. */
    @FXML
    private Text description;



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
    public AnchorPane render() { return this; }

    /**
     * On click edit.
     */
    @FXML
    public void onClickEdit() {
        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("invoice"));
        controller.getRouter().nav("invoices/edit/" + invoiceId);
    }

    /**
     * On click generate pdf.
     *
     * @throws ParseException the parse exception
     */
    @FXML
    public void onClickGeneratePdf() throws ParseException {
        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("invoice"));
        controller.setInvoice(invoiceId);
        controller.getInvoice().generatePdf();
    }

    /**
     * On click back.
     */
    @FXML
    public void onClickBack() {
        controller.getRouter().nav("invoices/");
    }

    /**
     * Sets the attributes.
     *
     * @param invoice the new attributes
     */
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
