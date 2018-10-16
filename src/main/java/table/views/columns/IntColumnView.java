package table.views.columns;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import table.exceptions.ViewNotFoundException;
import table.views.ColumnView;

public class IntColumnView extends Pane implements ColumnView<Integer> {

    private final String resource = "/views/table/rows/IntColumnView.fxml";

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
        return Integer.class;
    }

    @Override
    public Pane render() {
        return this;
    }

}
