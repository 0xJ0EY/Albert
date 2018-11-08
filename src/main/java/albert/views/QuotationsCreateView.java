package albert.views;

import albert.controllers.PageController;
import albert.controllers.QuotationsController;
import albert.models.Amount;
import albert.models.Contact;
import albert.models.Project;
import albert.models.Quotation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class QuotationsCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsCreateView.fxml";
    private QuotationsController controller;


    @FXML
    private TextField Name;

    @FXML
    private TextField Product;

    @FXML
    private TextField HoursExpected;

    @FXML
    private TextField PriceExpected;

    @FXML
    private ComboBox projectConnect;

    @FXML
    private TextArea Description;

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
        this.controller.getTemplate().addAction("Terug", () -> this.onClickBack());
        this.controller.getTemplate().addAction("Opslaan", () -> this.onClickSave());

        ArrayList<Project> projects = controller.getProjects();
        for(int i = 0; i < projects.size(); i++ ) {
            projectConnect.getItems().add(projects.get(i).getName());
        }

        projectConnect.setValue("Kies een project");

    }

    @Override
    public void setController(PageController controller) {
        this.controller = (QuotationsController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickSave(){
        int projectId = controller.getProjectIdFromName(projectConnect.getValue().toString());
        controller.saveQuotation(Name.getText(),
                Product.getText(),
                Double.parseDouble(HoursExpected.getText()),
                Double.parseDouble(PriceExpected.getText()),
                projectId,
                Description.getText());
        controller.getRouter().nav("quotations/");
    }

    public void onClickBack(){
        controller.getRouter().nav("quotations/");
    }
}
