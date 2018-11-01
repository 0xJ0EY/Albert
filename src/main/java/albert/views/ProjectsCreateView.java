package albert.views;

import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import albert.models.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ProjectsCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectEditView.fxml";
    private ProjectsController controller;
    private Project project;

    @FXML
    private TextField name;

    @FXML
    private Button klant;

    @FXML
    private RadioButton afgerondJa;

    @FXML
    private RadioButton afgerondNee;

    @FXML
    private TextField beschrijving;


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
    public void clickOnSave(ActionEvent event){
        System.out.println("Click on Save");
        controller.saveProject(name.getText(), afgerondJa.isSelected());
    }


}
