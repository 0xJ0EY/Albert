package albert.views;

import albert.controllers.PageController;
import albert.controllers.QuotationsController;
import albert.models.Amount;
import albert.models.Quotation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class QuotationsCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/QuotationsCreateView.fxml";
    private QuotationsController controller;
    private Quotation quotation;
    private Amount amount;

    @FXML
    private TextField naamBar;

    @FXML
    private TextField hourBar;

    @FXML
    private TextField priceBar;

    @FXML
    private TextField contactBar;

    @FXML
    private TextField delivery;

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
        this.controller = (QuotationsController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void clickOnSave(ActionEvent event){
        //TODO: verplaats deze logica naar de controller
        System.out.println("Click on Save");
        amount = new Amount(new Double(priceBar.getText()), new Double(hourBar.getText()), contactBar.getText());
        quotation = new Quotation(naamBar.getText(), amount, delivery.getText());
        controller.createObj(quotation);
    }
}
