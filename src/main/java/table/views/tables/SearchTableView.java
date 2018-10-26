package table.views.tables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import table.exceptions.ViewNotFoundException;

public class SearchTableView extends BaseTableView {

    private final String resource = "/views/table/tables/SearchTableView.fxml";

    @FXML
    private TextField searchField;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ViewNotFoundException();
        }
    }

    @FXML
    void onClickSearch() {
        this.table.search(this.searchField.getText());
    }

}
