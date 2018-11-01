package albert.views;

import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ProjectsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectEditView.fxml";
    private ProjectsController controller;

    @FXML
    private TextField naam;

    @FXML
    private TextField klant;

    @FXML
    private CheckBox isDone;

    @FXML
    private TextArea beschrijving;

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
        controller.saveProject(naam.getText(), isDone.isSelected());


    }

    @FXML
    public void onClickCancel() {
        controller.getRouter().nav("projects/1/");
    }

}
