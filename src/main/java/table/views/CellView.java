package table.views;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.Value;

public interface CellView<T> {

    public void load();

    public void update();

    public Priority getPriority();

    public void setValue(Value value);

    /**
     * Return the object required to display this object
     * @return
     */
    public Object getObjectClass();

    public AnchorPane render();

}
