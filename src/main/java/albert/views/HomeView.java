package albert.views;

import albert.controllers.HomeController;
import albert.controllers.PageController;
import javafx.fxml.FXML;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class HomeView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/Home.fxml";
    private HomeController controller;

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
        this.controller = (HomeController) controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }


    public void clickOnProjects(){
        controller.getRouter().nav("projects/1/");
    }


    public void clickOnInvoices(){
        controller.getRouter().nav("invoices/1");
    }


    public void clickOnReports(){
        controller.getRouter().nav("reports/1");
    }


}
