package albert.views;

import albert.controllers.PageController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
/*
Hier wordt de DetailView geladen
 */


public class ProjectsDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectsDetail.fxml";
    private PageController controller;

    @FXML
    private AnchorPane quotationOverviewTable;

    @FXML
    private AnchorPane invoiceOverviewTable;

    @FXML
    private AnchorPane expenseOverviewTable;

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
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickBack(){
        controller.getRouter().nav("projects/");
    }

    @FXML
    public void onClickEdit() {
        controller.getRouter().nav("projects/edit/{project}/");
    }

    @FXML
    public void onClickAddQuotation() {
        controller.getRouter().nav("quotations/create/");
    }

    @FXML
    public void onClickAddInvoice() {
        controller.getRouter().nav("invoices/create/");
    }
    @FXML

    public void onClickAddExpense() {
        controller.getRouter().nav("projects/edit/{project}/");
    }
}
