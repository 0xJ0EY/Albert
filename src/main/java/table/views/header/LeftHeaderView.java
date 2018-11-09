package table.views.header;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import table.exceptions.ViewNotFoundException;
import table.views.HeaderView;

// TODO: Auto-generated Javadoc
/**
 * The Class LeftHeaderView.
 * @author
 */
public class LeftHeaderView extends AnchorPane implements HeaderView {

    /** The label. */
    @FXML
    private Label label;

    /** The resource. */
    private final String resource = "/views/table/header/LeftHeaderView.fxml";
    
    /** The name. */
    private String name;

    /**
     * Instantiates a new left header view.
     *
     * @param name the name
     */
    public LeftHeaderView(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see table.views.HeaderView#load()
     */
    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            throw new ViewNotFoundException();
        }
    }

    /* (non-Javadoc)
     * @see table.views.HeaderView#update()
     */
    @Override
    public void update() {
        this.label.setText(this.name);
    }

    /* (non-Javadoc)
     * @see table.views.HeaderView#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see table.views.HeaderView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }
}
