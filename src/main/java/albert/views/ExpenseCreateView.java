package albert.views;

import albert.controllers.ExpenseController;
import albert.controllers.PageController;
import albert.controllers.RapportsController;
import albert.models.Project;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import router.views.PageView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ExpenseCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ExpenseCreate.fxml";
    private ExpenseController controller;
    DecimalFormat df = new DecimalFormat("####0.00");
    double btw = 1.21;

    @FXML
    private TextField Name;

    @FXML
    private CheckBox projectOnkost;

    @FXML
    private ComboBox projectKoppel;

    @FXML
    private TextField Price;

    @FXML
    private Text NettoBedrag;

    @FXML
    private TextField Description;


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
        projectKoppel.setDisable(true);
        ArrayList<Project> projects = controller.getProjects();
        for(int i = 0; i < projects.size(); i++ ) {
            projectKoppel.getItems().add(projects.get(i).getName());
        }

        projectKoppel.setValue("Kies een project");

    }

    @Override
    public void setController(PageController controller) {
        this.controller =(ExpenseController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("expenses/");
    }

    @FXML
    public void onClickSave() {
        int projectId = controller.getProjectIdFromName(projectKoppel.getValue().toString());
        controller.saveExpense(Double.parseDouble(Price.getText()), Description.getText(), Name.getText(), projectId);
        this.controller.getRouter().nav("expenses/");
    }

    @FXML
    public void onClickCalculate(){
        double netto = Double.parseDouble(Price.getText()) * btw;
        NettoBedrag.setText(df.format(netto));
    }

    @FXML
    public void onClickProjectCheck(){
        if (projectOnkost.isSelected()){
            projectKoppel.setDisable(false);
        } else {
            projectKoppel.setDisable(true);
        }
    }


}
