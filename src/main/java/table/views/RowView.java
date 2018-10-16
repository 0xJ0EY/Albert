package table.views;

import javafx.scene.layout.HBox;
import table.Row;

public interface RowView {

    public void load();

    public void update();

    public void setRow(Row row);

    public HBox render();

}
