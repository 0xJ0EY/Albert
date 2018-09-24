package albert.controllers;

import javafx.scene.Parent;

import java.io.IOException;

public interface TemplateController {

    public void setPage(PageController page) throws IOException;

    public Parent render();

}
