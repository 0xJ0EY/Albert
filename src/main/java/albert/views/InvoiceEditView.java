package albert.views;

import albert.controllers.InvoicesController;
import albert.controllers.PageController;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class InvoiceEditView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/InvoiceEditView.fxml";
    private InvoicesController controller;

    @FXML
    private TextField name;

    @FXML
    private TextField contact;

    @FXML
    private TextField hours;

    @FXML
    private TextField price;

    @FXML
    private  TextField project;

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
        this.controller = (InvoicesController)controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickButton() {
        this.controller.getRouter().nav("home/");
    }

    @FXML
    public void onClickSave() {
        controller.saveInvoice(name.getText(), price.getText(), hours.getText(), contact.getText(), delivery.getText());
    }
}
