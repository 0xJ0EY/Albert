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

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectsView.
 * @author
 */
public class ProjectsView extends AnchorPane implements PageView  {

    /** The resource. */
    private final String resource = "/views/pages/Projects.fxml";
    
    /** The controller. */
    private ProjectsController controller;

    /** The overview table. */
    @FXML
    private AnchorPane overviewTable;

    /** The edit button. */
    @FXML
    private Button editButton;

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
     * On click done.
     */
    @FXML
    public void onClickDone(){
        controller.getRouter().nav("projects/done/");
    }
}
