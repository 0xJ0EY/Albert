package albert.views;

import albert.controllers.ExpenseController;
import albert.controllers.PageController;
import albert.controllers.RapportsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import router.views.PageView;

import java.text.DecimalFormat;

public class ExpenseCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ExpenseCreate.fxml";
    private ExpenseController controller;
    DecimalFormat df = new DecimalFormat("####0.00");
    double btw = 1.21;

    @FXML
    private TextField Name;

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
        controller.saveExpense(Double.parseDouble(Price.getText()), Description.getText(), Name.getText() );
    }

    @FXML
    public void onClickCalculate(){
        double netto = Double.parseDouble(Price.getText()) * btw;
        NettoBedrag.setText(df.format(netto));
    }


}
