package table.views.cells;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.Value;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;

public class TextCellView extends AnchorPane implements CellView<String> {

    private final String resource = "/views/table/cells/TextCellView.fxml";
    private Value value;

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

    @Override
    public void update() {

    }

    @Override
    public Priority getPriority() {
        return Priority.ALWAYS;
    }

    @Override
    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public Object getObjectClass() {
        return String.class;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

}
