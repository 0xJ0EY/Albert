package albert.views;

import albert.controllers.ContactController;
import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import table.Table;
import table.views.TableView;


public class ContactsView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactView.fxml";
    private ContactController controller;

    @FXML
    private AnchorPane overviewTable;

    @FXML
    private TextField search;

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
//        Table table = controller.getOverviewTable();
//
//        table.update();
//
//        TableView tableView = table.getView();
//
//        this.overviewTable.getChildren().add(tableView.render());
    }

    @Override
    public void setController(PageController controller) {
        this.controller =(ContactController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickAddContact(){
        controller.getRouter().nav("contacts/create/{new}");
    }


}
