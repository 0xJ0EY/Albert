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

/**
 * The Class InvoiceView. Loads the InvoiceView
 *
 */
public class InvoiceView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/InvoiceView.fxml";
    
    /** The controller. */
    private InvoicesController controller;

    /** The overview table. */
    @FXML
    private AnchorPane overviewTable;

    /** The searchform. */
    @FXML
    private TextField searchform;

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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
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
    public AnchorPane render() {
        return this;
    }

    /**
     * On click add invoice.
     */
    @FXML
    public void onClickAddInvoice(){
        controller.getRouter().nav("invoices/create/");
    }


    /**
     * On click paid.
     */
    @FXML
    public void onClickPaid(){
        controller.getRouter().nav("invoicespaid/");
    }

}
