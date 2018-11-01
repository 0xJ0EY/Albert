package table.views;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.cells.Cell;

public interface CellView {

    public void load();

    public void update();

    public Priority getPriority();

    public void setCell(Cell cell);

    public AnchorPane render();

}
