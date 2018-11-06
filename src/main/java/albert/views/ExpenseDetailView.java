package albert.views;

import albert.controllers.ExpenseController;
import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import router.views.PageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpenseDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ExpenseDetail.fxml";
    private ExpenseController controller;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @FXML
    private Text Name;

    @FXML
    private Text Price;

    @FXML
    private Text NettoBedrag;

    @FXML
    private Text DateCreated;

    @FXML
    private Text Description;

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
    public void onClickEdit() {

        this.controller.navigateEditExpense();

    }


    public void fillForm(){
        controller.setExpense(Integer.parseInt(this.controller.getRequest().getParameter("expense")));
        Name.setText(controller.getExpense().getName());
        Price.setText(String.valueOf(controller.getExpense().getPrice()));
        NettoBedrag.setText(getNettoBedrag(controller.getExpense().getPrice()));
        DateCreated.setText(getDateString(controller.getExpense().getCreated_at()));
        Description.setText(controller.getExpense().getDescription());
    }

    public String getNettoBedrag(double bedrag){
        return String.format( "%.2f", (bedrag * controller.getExpense().getBtw()));
    }

    public String getDateString(Date date){
        return formatter.format(date);
    }


}
