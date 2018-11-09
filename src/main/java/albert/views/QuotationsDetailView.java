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

/**
 * The Class QuotationsDetailView. Loads the QuotationsDetailView
 *
 */
public class QuotationsDetailView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/QuotationsDetail.fxml";
    
    /** The formatter. */
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    /** The controller. */
    private QuotationsController controller;

    /** The Name. */
    @FXML
    private Text Name;

    /** The Product. */
    @FXML
    private Text Product;

    /** The Hours. */
    @FXML
    private Text Hours;

    /** The Price. */
    @FXML
    private Text Price;

    /** The Project. */
    @FXML
    private Text Project;

    /** The Date created. */
    @FXML
    private Text DateCreated;

    /** The Description. */
    @FXML
    private Text Description;

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
        this.controller.getTemplate().addAction("Genereer PDF", () -> {
            try {
                this.onClickGeneratePDF();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        this.controller.getTemplate().addAction("Offerte aanpassen", () -> this.onClickEdit());

        this.fillForm();
    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller =(QuotationsController) controller;
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
        this.controller.getRouter().nav("quotations/");
    }

    /**
     * On click edit.
     */
    @FXML
    public void onClickEdit() {
        this.controller.getRouter().nav("quotations/edit/" + controller.getCurrentId());
    }

    /**
     * On click generate PDF.
     *
     * @throws ParseException the parse exception
     */
    @FXML
    public void onClickGeneratePDF() throws ParseException {
        int quotationId = Integer.parseInt(this.controller.getRequest().getParameter("quotation"));
        controller.setQuotation(quotationId);
        controller.getQuotation().generatePdf();
    }

    /**
     * Fill form.
     */
    public void fillForm(){
        controller.setQuotation(Integer.parseInt(this.controller.getRequest().getParameter("quotation")));
        Name.setText(controller.getQuotation().getName());
        Product.setText(controller.getQuotation().getProduct());
        Hours.setText(Double.toString(controller.getQuotation().getExpectedHours()));
        Price.setText(Double.toString(controller.getQuotation().getExpectedPrice()));
        Project.setText(controller.getQuotation().getProject().getName());
        DateCreated.setText(getDateString(controller.getQuotation().getCreated_at()));
        Description.setText(controller.getQuotation().getDescription());
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
