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

public class ExpenseView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ExpenseView.fxml";
    private ExpenseController controller;

    @FXML
    private AnchorPane overviewTable;

    @FXML
    private TextField searchBar;

    @FXML
    private Button GeneratePDF;

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

    @Override
    public void setController(PageController controller) {
        this.controller =(ExpenseController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickAddExpense() {

        this.controller.getRouter().nav("expenses/create/");

    }

}
