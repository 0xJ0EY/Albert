package albert.views;

import albert.controllers.ExpenseController;
import albert.controllers.PageController;
import albert.controllers.RapportsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;
import table.Table;
import table.views.TableView;

import java.io.IOException;


/**
 * The Class ExpenseView. Loads the ExpenseView
 *
 */
public class ExpenseView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ExpenseView.fxml";
    
    /** The controller. */
    private ExpenseController controller;

    /** The overview table. */
    @FXML
    private AnchorPane overviewTable;

    /** The search bar. */
    @FXML
    private TextField searchBar;

    /** The Generate PDF. */
    @FXML
    private Button GeneratePDF;

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
        this.controller.getTemplate().addAction("Nieuwe onkost", () -> this.onClickAddExpense());

        Table table = controller.getOverviewTable();

        table.fetch();

        table.update();

        TableView tableView = table.getView();

        AnchorPane view = tableView.render();

        AnchorPane.setRightAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);
        this.overviewTable.getChildren().add(view);

    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller =(ExpenseController) controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click add expense.
     */
    @FXML
    public void onClickAddExpense() {

        this.controller.getRouter().nav("expenses/create/");

    }

}
