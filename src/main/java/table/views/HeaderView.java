package table.views;

import javafx.scene.layout.AnchorPane;

public interface HeaderView {

    public void load();

    public void update();

    public void setName(String name);

    public AnchorPane render();

}
