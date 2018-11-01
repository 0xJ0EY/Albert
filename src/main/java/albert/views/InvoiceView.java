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
        Table table = controller.getOverviewTable();

        table.fetch();

        table.update();

        TableView tableView = table.getView();

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

    public void onClickSearch(){

    }
    public void clickOnEdit(){

    }

    public void clickOnDelete(){

    }

    public void clickOnPdf(){

    }
}
