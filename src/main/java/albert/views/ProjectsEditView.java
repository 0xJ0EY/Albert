package albert.views;

import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ProjectsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsEditView.fxml";
    private ProjectsController controller;

    @FXML
    private TextField naam;

    @FXML
    private TextField klant;

    @FXML
    private CheckBox isDone;

    @FXML
    private TextArea beschrijving;

    private ChoiceBox contactDropBox;

    @FXML
    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void setController(PageController controller) {
        this.controller = (ProjectsController)controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickSave() {
//        controller.saveProject(naam.getText(), isDone.isSelected());


    }

    @FXML
    public void onClickBack() {
        controller.getRouter().nav("projects/");
    }

}
