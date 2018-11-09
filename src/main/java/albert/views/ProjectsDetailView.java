package albert.views;

import albert.controllers.PageController;
import albert.controllers.ProjectsController;
import albert.models.Contact;
import albert.models.Project;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import table.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectsDetailView.
 * @author
 */
public class ProjectsDetailView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ProjectsDetail.fxml";
    
    /** The controller. */
    private ProjectsController controller;

    /** The name. */
    @FXML
    private Text name;

    /** The customer. */
    @FXML
    private Text customer;

    /** The done. */
    @FXML
    private Text done;

    /** The description. */
    @FXML
    private TextArea description;

    /** The invoice overview. */
    @FXML
    private AnchorPane invoiceOverview;

    /** The expenses overview. */
    @FXML
    private AnchorPane expensesOverview;

    /** The quotation overview. */
    @FXML
    private AnchorPane quotationOverview;

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
        this.controller.getTemplate().addAction("Nieuw Project", () -> controller.getRouter().nav("projects/create/"));
        this.controller.getTemplate().addAction("Nieuwe Offerte", () -> controller.getRouter().nav("quotations/create/"));
        this.controller.getTemplate().addAction("Nieuwe Onkost", () -> controller.getRouter().nav("expenses/create/"));

        this.controller.getTemplate().addAction("Terug", () -> this.onClickBack());

        Project project = this.controller.getProject();

        this.name.setText(project.getName());
        this.customer.setText(project.getContact().toFullName());
        this.done.setText(project.getDone() ? "Afgerond" : "Niet afgerond");
        this.description.setText(project.getDescription());

        this.setupTable(this.controller.getInvoicesTable(project), this.invoiceOverview);
        this.setupTable(this.controller.getExpensesTable(project), this.expensesOverview);
        this.setupTable(this.controller.getQuotationTable(project), this.quotationOverview);

    }

    /**
     * Setup table.
     *
     * @param table the table
     * @param target the target
     */
    public void setupTable(Table table, AnchorPane target) {

        table.fetch();
        table.update();

        AnchorPane tableView = table.getView().render();

        AnchorPane.setRightAnchor(tableView, 0.0);
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setTopAnchor(tableView, 0.0);
        AnchorPane.setBottomAnchor(tableView, 0.0);

        target.getChildren().add(tableView);
    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (ProjectsController) controller;
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
    public void onClickBack(){
        controller.getRouter().nav("projects/");
    }

    /**
     * On customer click.
     */
    @FXML
    public void onCustomerClick() {
        Contact contact = this.controller.getProject().getContact();
        this.controller.getRouter().nav("contacts/details/" + contact.getId());
    }

}
