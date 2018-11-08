package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import albert.models.*;
import albert.services.PdfService;
import com.itextpdf.text.DocumentException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;
import table.Table;
import table.views.TableView;

import java.io.IOException;

public class InvoiceView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceView.fxml";
    private InvoicesController controller;

    @FXML
    private AnchorPane overviewTable;

    @FXML
    private TextField searchform;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void update() {
        this.controller.getTemplate().addAction("Nieuwe factuur", () -> this.onClickAddInvoice());

        Table table = controller.getOverviewTable();

        table.fetch();

        table.update();

        TableView tableView = table.getView();
        AnchorPane render = tableView.render();

        AnchorPane.setRightAnchor(render, 0.0);
        AnchorPane.setLeftAnchor(render, 0.0);
        AnchorPane.setTopAnchor(render, 0.0);
        AnchorPane.setBottomAnchor(render, 0.0);

        this.overviewTable.getChildren().add(tableView.render());
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
    public void onClickAddInvoice(){
        controller.getRouter().nav("invoices/create/");
    }


    @FXML
    public void onClickPaid(){
        controller.getRouter().nav("invoicespaid/");
    }

}
