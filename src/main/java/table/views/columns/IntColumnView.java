package table.views.columns;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import table.Value;
import table.exceptions.ViewNotFoundException;
import table.views.ColumnView;

public class IntColumnView extends AnchorPane implements ColumnView<Integer> {


    @FXML
    private Label label;

    private final String resource = "/views/table/columns/IntColumnView.fxml";
    private Value value;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();;
            throw new ViewNotFoundException();
        }
    }

    @Override
    public void update() {
        int value = (int) this.value.getObject();

        label.setText(Integer.toString(value));
    }

    @Override
    public Priority getPriority() {
        return Priority.SOMETIMES;
    }

    @Override
    public HPos getHPos() {
        return HPos.RIGHT;
    }

    @Override
    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public Object getObjectClass() {
        return Integer.class;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

}
