package albert.views;

import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;
import table.Table;
import table.views.TableView;

import java.awt.*;
import java.io.IOException;
/*
Hier wordt de prrojects geladen
 */

public class ProjectsDoneView extends AnchorPane implements PageView  {

    private final String resource = "/views/pages/ProjectsDone.fxml";
    private ProjectsController controller;

    @FXML
    private AnchorPane overviewTable;


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
        Table table = controller.getDoneOverviewTable();

        table.fetch();

        table.update();

        TableView tableView = table.getView();

        this.overviewTable.getChildren().add(tableView.render());
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
    public void onClickOngoing(){
        controller.getRouter().nav("projects/");
    }
}
