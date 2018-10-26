package table.views;

import javafx.scene.layout.AnchorPane;
import table.Table;

public interface TableView {

    public void load();

    public void update();

    public void setTable(Table table);

    public AnchorPane render();

}
