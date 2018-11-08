package albert.views;

import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import router.pages.CreatePage;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import table.Table;
import table.views.TableView;

import java.awt.*;
import java.io.IOException;

public class ProjectsView extends AnchorPane implements PageView  {

    private final String resource = "/views/pages/Projects.fxml";
    private ProjectsController controller;

    @FXML
    private AnchorPane overviewTable;

    @FXML
    private Button editButton;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {
        Table table = controller.getOverviewTable();

        table.fetch();

        table.update();

        AnchorPane render = table.getView().render();

        AnchorPane.setRightAnchor(render, 0.0);
        AnchorPane.setLeftAnchor(render, 0.0);
        AnchorPane.setTopAnchor(render, 0.0);
        AnchorPane.setBottomAnchor(render, 0.0);

        this.overviewTable.getChildren().add(render);
    }

    @Override
    public void setController(PageController controller) {
        this.controller = (ProjectsController)controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    public void onClickNewProject(){

        controller.getRouter().nav("projects/create/");
    }

    @FXML
    public void onClickDone(){
        controller.getRouter().nav("projects/done/");
    }
}
