package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;
import table.Table;
import table.views.TableView;

import java.io.IOException;

public class InvoiceViewPaid extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceViewPaid.fxml";
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
        Table table = controller.getPaidOverviewTable();

        table.fetch();

        table.update();

        TableView tableView = table.getView();
        AnchorPane render = tableView.render();

        AnchorPane.setRightAnchor(render, 0.0);
        AnchorPane.setLeftAnchor(render, 0.0);
        AnchorPane.setTopAnchor(render, 0.0);
        AnchorPane.setBottomAnchor(render, 0.0);

        this.overviewTable.getChildren().add(render);
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
    public void onClickNotPaid(){
        controller.getRouter().nav("invoices/");
    }
}
