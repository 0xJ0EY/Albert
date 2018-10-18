package router.templates;

import albert.controllers.PageController;
import javafx.scene.Parent;
import router.Router;

import java.io.IOException;

public interface TemplateController {

    public void setPage(PageController page);

    public Parent render();

}
