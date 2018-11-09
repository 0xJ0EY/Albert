package table.views.tables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import table.exceptions.ViewNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchTableView.
 * @author
 */
public class SearchTableView extends BaseTableView {

    /** The resource. */
    private final String resource = "/views/table/tables/SearchTableView.fxml";

    /** The search field. */
    @FXML
    private TextField searchField;

    /* (non-Javadoc)
     * @see table.views.tables.BaseTableView#load()
     */
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

    /**
     * On click search.
     */
    @FXML
    void onClickSearch() {
        this.table.search(this.searchField.getText());
    }

}
