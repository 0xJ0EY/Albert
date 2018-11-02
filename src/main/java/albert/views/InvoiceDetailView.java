package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import javafx.scene.control.CheckBox;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.text.ParseException;

public class InvoiceDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceDetailView.fxml";
    private InvoicesController controller;

    @FXML
    private CheckBox vink;

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
    public void onClickEdit() {
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
}
