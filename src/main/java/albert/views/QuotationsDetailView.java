package albert.views;

import albert.controllers.PageController;
import albert.controllers.QuotationsController;
import javafx.scene.text.Text;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuotationsDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsDetail.fxml";
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private QuotationsController controller;

    @FXML
    private Text Name;

    @FXML
    private Text Product;

    @FXML
    private Text Hours;

    @FXML
    private Text Price;

    @FXML
    private Text Project;

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
    public void onClickEdit() {
        this.controller.getRouter().nav("quotations/edit/{quotation}/)");
    }

    @FXML
    public void onClickGeneratePDF() throws ParseException {
        int quotationId = Integer.parseInt(this.controller.getRequest().getParameter("quotation"));
        controller.setQuotation(quotationId);
        controller.getQuotation().generatePdf();
    }

    public void fillForm(){
        controller.setQuotation(Integer.parseInt(this.controller.getRequest().getParameter("quotation")));
//        controller.getQuotation().setProjectId(Integer.parseInt(this.controller.getRequest().getParameter("project")));
        Name.setText(controller.getQuotation().getName());
        Product.setText(controller.getQuotation().getProduct());
        Hours.setText(Integer.toString(controller.getQuotation().getExpectedHours()));
        Price.setText(Double.toString(controller.getQuotation().getExpectedPrice()));
        Project.setText(Integer.toString(controller.getQuotation().getProject().getId()));
        DateCreated.setText(getDateString(controller.getQuotation().getCreated_at()));
        Description.setText(controller.getQuotation().getDescription());
    }

    public String getDateString(Date date){
        return formatter.format(date);
    }
}
