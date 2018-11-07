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

public class ProjectsDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectsDetail.fxml";
    private ProjectsController controller;

    @FXML
    private Text name;

    @FXML
    private Text customer;

    @FXML
    private Text done;

    @FXML
    private TextArea description;

    @FXML
    private AnchorPane invoiceOverview;

    @FXML
    private AnchorPane expensesOverview;

    @FXML
    private AnchorPane quotationOverview;

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
        Project project = this.controller.getProject();

        this.name.setText(project.getName());
        this.customer.setText(project.getContact().toFullName());
        this.done.setText(project.getDone() ? "Afgerond" : "Niet afgerond");
        this.description.setText(project.getDescription());

        this.setupTable(this.controller.getInvoicesTable(project), this.invoiceOverview);
        this.setupTable(this.controller.getExpensesTable(project), this.expensesOverview);
        this.setupTable(this.controller.getQuotationTable(project), this.quotationOverview);

    }

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

    @Override
    public void setController(PageController controller) {
        this.controller = (ProjectsController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickBack(){
        controller.getRouter().nav("projects/");
    }

    @FXML
    public void onCustomerClick() {
        Contact contact = this.controller.getProject().getContact();
        this.controller.getRouter().nav("contacts/details/" + contact.getId());
    }

}
