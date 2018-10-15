package albert.views;

import albert.controllers.PageController;
import albert.controllers.templates.TemplateController;
import javafx.scene.Parent;

public interface TemplateView {

    public void load(PageController page);

    public void setController(TemplateController controller);

    public Parent render();

}
