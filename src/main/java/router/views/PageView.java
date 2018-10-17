package router.views;

import albert.controllers.PageController;
import javafx.scene.layout.AnchorPane;

public interface PageView {

    public void load();

    public void setController(PageController controller);

    public AnchorPane render();

}
