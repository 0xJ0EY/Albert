package albert.views;

import albert.controllers.PageController;
import albert.controllers.QuotationsController;
import albert.models.Quotation;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.text.ParseException;

public class QuotationsDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsDetail.fxml";
    private QuotationsController controller;

    @FXML
    private Button editButton;

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
        this.controller = (QuotationsController)controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("quotations/");
    }

    @FXML
    public void onClickEdit() {
        this.controller.getRouter().nav("quotations/edit/{quotation}/)");
    }

    @FXML
    public void onClickGeneratePdf() throws ParseException {
        int invoiceId = Integer.parseInt(this.controller.getRequest().getParameter("quotation"));
        controller.setQuotation(invoiceId);
        controller.getQuotation().generatePdf();
    }
}
