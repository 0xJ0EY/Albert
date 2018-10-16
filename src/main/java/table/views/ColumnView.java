package table.views;

import javafx.scene.layout.Pane;

public interface ColumnView<T> {

    public void load();

    public void update();

    /**
     * Return the object required to display this object
     * @return
     */
    public Object getObjectClass();

    public Pane render();

}
