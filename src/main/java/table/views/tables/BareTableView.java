package table.views.tables;

import javafx.fxml.FXMLLoader;
import table.exceptions.ViewNotFoundException;
import table.views.TableView;

// TODO: Auto-generated Javadoc
/**
 * The Class BareTableView.
 * @author
 */
public class BareTableView extends BaseTableView implements TableView {

    /** The resource. */
    private final String resource = "/views/table/tables/BareTableView.fxml";

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
}
