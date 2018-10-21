package albert.views;

import albert.controllers.PageController;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class HomeView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/Home.fxml";
    private PageController controller;

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
    public void setController(PageController controller) {
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    public void clickOnContacts(){
        controller.getRouter().nav("contacts/{page}/");
    }
    public void clickOnProject(){
        controller.getRouter().nav("projects/1/");
    }
    public void clickOnInvoice(){
        controller.getRouter().nav("invoices/1");
    }
    public void clickOnRapports(){
        System.out.println("print Rapports");
        controller.getRouter().nav("rapports/1");
    }

}
