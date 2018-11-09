package table.views.tables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import table.exceptions.ViewNotFoundException;

/**
 * The Class EditTableView.
 *
 */
public class EditTableView extends BaseTableView {

    /** The resource. */
    private final String resource = "/views/table/tables/EditTableView.fxml";

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

    /* (non-Javadoc)
     * @see table.views.tables.BaseTableView#update()
     */
    @Override
    public void update() {
        // Update overlay text
        this.updateOverlay();

        // Show the overlay
        this.showOverlay();

        // Scroll up
        this.scrollUp();

        // Create buttons
        this.createButtons();

        // Create cells
        this.createColumns();

        // Update the text below
        this.updateText();

        // Create headers
        this.createHeaders();

        // Create the rows with data in the columns
        this.createRows();

        // Actually render the table to the view
        this.updateTable();

        // Hide table if the status is loaded and we have more then 0 rows
        if (this.table.isLoaded() && this.table.getTotalRows() > 0)
            this.hideOverlay();
    }

}
