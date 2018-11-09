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

/**
 * The Class QuotationsCreateView. Loads the QuotationsCreateView
 *
 */
public class QuotationsCreateView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/QuotationsCreateView.fxml";
    
    /** The controller. */
    private QuotationsController controller;


    /** The Name. */
    @FXML
    private TextField Name;

    /** The Product. */
    @FXML
    private TextField Product;

    /** The Hours expected. */
    @FXML
    private TextField HoursExpected;

    /** The Price expected. */
    @FXML
    private TextField PriceExpected;

    /** The project connect. */
    @FXML
    private ComboBox projectConnect;

    /** The Description. */
    @FXML
    private TextArea Description;

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

        ArrayList<Project> projects = controller.getProjects();
        for(int i = 0; i < projects.size(); i++ ) {
            projectConnect.getItems().add(projects.get(i).getName());
        }

        projectConnect.setValue("Kies een project");

    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (QuotationsController) controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click save.
     */
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

    /**
     * On click back.
     */
    public void onClickBack(){
        controller.getRouter().nav("quotations/");
    }
}
