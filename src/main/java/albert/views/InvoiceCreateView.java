package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import albert.models.Amount;
import albert.models.Invoice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class InvoiceCreateView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceCreateView.fxml";
    private InvoicesController controller;
    private Invoice invoice;
    private Amount amount;

    @FXML
    private TextField name;

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
    public void clickOnSave(ActionEvent event){
        System.out.println("Click on Save");
        controller.saveInvoice(name.getText(), price.getText(), hours.getText(), contact.getText(), delivery.getText());
    }
}
