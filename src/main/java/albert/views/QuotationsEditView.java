package albert.views;

import albert.controllers.PageController;
import albert.controllers.QuotationsController;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class QuotationsEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsEditView.fxml";
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
    private Text Project;

    @FXML
    private DatePicker Date;

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
        this.fillForm();
    }

    @Override
    public void setController(PageController controller) {
        this.controller =(QuotationsController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickBack() {
        this.controller.getRouter().nav("quotations/");
    }

    @FXML
    public void onClickSave() {

    }

    public void fillForm(){
        controller.setQuotation(Integer.parseInt(this.controller.getRequest().getParameter("quotation")));
        Name.setText(controller.getQuotation().getName());
        Product.setText(String.valueOf(controller.getQuotation().getProduct()));
        HoursExpected.setText(Double.toString(controller.getQuotation().getExpectedHours()));
        PriceExpected.setText(Double.toString(controller.getQuotation().getExpectedPrice()));
        Project.setText(controller.getQuotation().getProject().getName());
        Description.setText(controller.getQuotation().getDescription());

    }
}
