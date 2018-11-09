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

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceViewPaid.
 * @author
 */
public class InvoiceViewPaid extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/InvoiceViewPaid.fxml";
    
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
     * On click not paid.
     */
    @FXML
    public void onClickNotPaid(){
        controller.getRouter().nav("invoices/");
    }
}
