package albert.controllers;

import albert.views.PageView;
import javafx.scene.layout.AnchorPane;

public interface PageController {

    public void setTemplate(TemplateController template);

    public void setView(PageView view);

    public AnchorPane render();

}
