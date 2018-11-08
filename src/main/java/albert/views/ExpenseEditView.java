package albert.views;

import albert.controllers.ExpenseController;
import albert.controllers.PageController;
import albert.models.Project;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import router.views.PageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpenseEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ExpenseEdit.fxml";
    private ExpenseController controller;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");



    @FXML
    private TextField Name;

    @FXML
    private TextField Price;

    @FXML
    private Text NettoBedrag;

    @FXML
    private TextField DateCreated;

    @FXML
    private TextField Description;

    @FXML
    private Text projectName;

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
        this.controller.getTemplate().addAction("Terug", () -> this.onClickSave());

        this.fillForm();
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
      int expenseID =Integer.parseInt(this.controller.getRequest().getParameter("expense"));
      controller.editExpense(expenseID, Name.getText(), Double.parseDouble(Price.getText()), Description.getText());
      this.controller.getRouter().nav("expenses/");
    }

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

    public String getNettoBedrag(double bedrag){
        return String.format( "%.2f", (bedrag * controller.getExpense().getBtw()));
    }

    public String getDateString(Date date){
        return formatter.format(date);
    }

}
