package albert.views;

import albert.controllers.HomeController;
import albert.controllers.PageController;
import albert.models.*;
import com.itextpdf.text.DocumentException;
import albert.services.PdfService;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
/*
Hier wordt de homeView geladen
 */
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

        this.controller.getTemplate().addAction("Projects", () -> controller.getRouter().nav("projects/"));

        this.controller.getTemplate().addAction("Invoices", () -> controller.getRouter().nav("invoices/"));

        this.controller.getTemplate().addAction("Reports", () -> controller.getRouter().nav("reports/"));

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
        controller.getRouter().nav("projects/");
    }


    public void clickOnInvoices(){
        controller.getRouter().nav("invoices/");
    }


    public void clickOnReports(){
        controller.getRouter().nav("reports/");
    }


}
