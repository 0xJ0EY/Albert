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
// TODO: Auto-generated Javadoc
/*
Hier wordt de prrojects geladen
 */

/**
 * The Class ProjectsDoneView.
 * @author
 */
public class ProjectsDoneView extends AnchorPane implements PageView  {

    /** The resource. */
    private final String resource = "/views/pages/ProjectsDone.fxml";
    
    /** The controller. */
    private ProjectsController controller;

    /** The overview table. */
    @FXML
    private AnchorPane overviewTable;


    /* (non-Javadoc)
     * @see router.views.PageView#load()
     */
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

    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
    @Override
    public void update() {

        this.controller.getTemplate().addAction(
            "Nieuw project",
            () -> controller.getRouter().nav("projects/create/")
        );

        Table table = controller.getDoneOverviewTable();

        table.fetch();

        table.update();

        TableView tableView = table.getView();
        AnchorPane render = tableView.render();

        AnchorPane.setRightAnchor(render, 0.0);
        AnchorPane.setLeftAnchor(render, 0.0);
        AnchorPane.setTopAnchor(render, 0.0);
        AnchorPane.setBottomAnchor(render, 0.0);

        this.overviewTable.getChildren().add(render);
    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (ProjectsController)controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click new project.
     */
    public void onClickNewProject(){

        controller.getRouter().nav("projects/create/");
    }

    /**
     * On click ongoing.
     */
    @FXML
    public void onClickOngoing(){
        controller.getRouter().nav("projects/");
    }
}
