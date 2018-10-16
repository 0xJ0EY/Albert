package router.views;

import albert.controllers.PageController;
import router.templates.TemplateController;
import javafx.scene.Parent;

public interface TemplateView {

    public void load(PageController page);

    public void setController(TemplateController controller);

    public Parent render();

}
