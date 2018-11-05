package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import albert.models.Amount;
import albert.models.Invoice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;

public class InvoiceCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceCreateView.fxml";
    private InvoicesController controller;
    private Invoice invoice;
    private Amount amount;

    @FXML
    private TextField contact;

    @FXML
    private TextField hours;

    @FXML
    private TextField price;

    @FXML
    private TextField project;

    @FXML
    private TextField delivery;

    @FXML
    private CheckBox betaaldBox;

    @FXML
    private DatePicker deliveryDate;


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
        this.controller = (InvoicesController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickSave(ActionEvent event){
        System.out.println("Click on Save");
        Date date = Date.from(deliveryDate.getValue().atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        Timestamp timeStamp = new Timestamp(date.getTime());
        controller.createInvoice(price.getText(), hours.getText(), betaaldBox.isSelected(), timeStamp);
    }

    @FXML
    public void onClickBack(ActionEvent event) { controller.getRouter().nav("invoice/1");   }
}
