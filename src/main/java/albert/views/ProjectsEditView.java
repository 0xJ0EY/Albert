package albert.views;

import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ProjectsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectEditView.fxml";
    private PageController controller;

    @FXML
    private TextField naam;

    @FXML
    private TextField klant;

    @FXML
    private RadioButton afgerondJa;

    @FXML
    private RadioButton afgerondNee;


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
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    public void onClickCancel(){

    }

    public void onClickEdit(){


    }


}
