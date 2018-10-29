package albert.views;

import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import table.Table;
import table.views.TableView;

import java.io.IOException;

public class ProjectsView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/Projects.fxml";
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
        Table table = controller.getOverviewTable();

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

}
