package table.views.columns;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import table.exceptions.ViewNotFoundException;
import table.views.ColumnView;

public class TextColumnView extends Pane implements ColumnView<String> {

    private final String resource = "/views/table/columns/TextColumnView.fxml";

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
    public Object getObjectClass() {
        return String.class;
    }

    @Override
    public Pane render() {
        return this;
    }

}
