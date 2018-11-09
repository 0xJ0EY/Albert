package albert.views;

import albert.controllers.ExpenseController;
import albert.controllers.PageController;
import albert.models.Project;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import router.Router;
import router.views.PageView;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseDetailView.
 * @author
 */
public class ExpenseDetailView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ExpenseDetail.fxml";
    
    /** The controller. */
    private ExpenseController controller;
    
    /** The formatter. */
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    /** The Name. */
    @FXML
    private Text Name;

    /** The Price. */
    @FXML
    private Text Price;

    /** The Netto bedrag. */
    @FXML
    private Text NettoBedrag;

    /** The Date created. */
    @FXML
    private Text DateCreated;

    /** The Description. */
    @FXML
    private Text Description;

    /** The project name. */
    @FXML
    private Text projectName;

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
        this.controller.getTemplate().addAction("Onkost aanpassen", () -> this.onClickEdit());

        this.fillForm();
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
     * On click edit.
     */
    @FXML
    public void onClickEdit() {

        this.controller.navigateEditExpense();

    }


    /**
     * Fill form.
     */
    public void fillForm(){
        controller.setExpense(Integer.parseInt(this.controller.getRequest().getParameter("expense")));
        Name.setText(controller.getExpense().getName());
        Price.setText(String.valueOf(controller.getExpense().getPrice()));
        NettoBedrag.setText(getNettoBedrag(controller.getExpense().getPrice()));
        DateCreated.setText(getDateString(controller.getExpense().getCreated_at()));
        Description.setText(controller.getExpense().getDescription());

        Project project = controller.getExpense().getProject();

        if (project != null)
            projectName.setText(controller.getExpense().getProject().getName());
    }

    /**
     * Gets the netto bedrag.
     *
     * @param bedrag the bedrag
     * @return the netto bedrag
     */
    public String getNettoBedrag(double bedrag){
        return String.format( "%.2f", (bedrag * controller.getExpense().getBtw()));
    }

    /**
     * Gets the date string.
     *
     * @param date the date
     * @return the date string
     */
    public String getDateString(Date date){
        return formatter.format(date);
    }


}
