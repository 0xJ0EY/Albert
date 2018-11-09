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

// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseCreateView.
 * @author
 */
public class ExpenseCreateView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ExpenseCreate.fxml";
    
    /** The controller. */
    private ExpenseController controller;
    
    /** The df. */
    DecimalFormat df = new DecimalFormat("####0.00");
    
    /** The btw. */
    double btw = 1.21;

    /** The Name. */
    @FXML
    private TextField Name;

    /** The project onkost. */
    @FXML
    private CheckBox projectOnkost;

    /** The project koppel. */
    @FXML
    private ComboBox projectKoppel;

    /** The Price. */
    @FXML
    private TextField Price;

    /** The Netto bedrag. */
    @FXML
    private Text NettoBedrag;

    /** The Description. */
    @FXML
    private TextField Description;


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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
    @Override
    public void update() {
        this.controller.getTemplate().addAction("Terug", () -> this.onClickBack());
        this.controller.getTemplate().addAction("Opslaan", () -> this.onClickSave());

        projectKoppel.setDisable(true);
        ArrayList<Project> projects = controller.getProjects();
        for(int i = 0; i < projects.size(); i++ ) {
            projectKoppel.getItems().add(projects.get(i).getName());
        }

        projectKoppel.setValue("Kies een project");

    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller =(ExpenseController) controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click back.
     */
    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("expenses/");
    }

    /**
     * On click save.
     */
    @FXML
    public void onClickSave() {
        int projectId = controller.getProjectIdFromName(projectKoppel.getValue().toString());
        controller.saveExpense(Double.parseDouble(Price.getText()), Description.getText(), Name.getText(), projectId);
        this.controller.getRouter().nav("expenses/");
    }

    /**
     * On click calculate.
     */
    @FXML
    public void onClickCalculate(){
        double netto = Double.parseDouble(Price.getText()) * btw;
        NettoBedrag.setText(df.format(netto));
    }

    /**
     * On click project check.
     */
    @FXML
    public void onClickProjectCheck(){
        if (projectOnkost.isSelected()){
            projectKoppel.setDisable(false);
        } else {
            projectKoppel.setDisable(true);
        }
    }


}
