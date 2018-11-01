package albert.views;

import albert.controllers.HomeController;
import albert.controllers.PageController;
import albert.models.Amount;
import albert.models.Contact;
import com.itextpdf.text.DocumentException;
import javafx.fxml.FXML;
import albert.models.Invoice;
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
       // controller.getRouter().nav("invoices/1");
        Contact contact = new Contact("HeinekenBV", "Henk", "Jandeberg", "Zoeterwoudeweg", "15", "2254BB", "Zoeterwoude Rijndijk");
        Amount amount = new Amount(1600.32, 15.0, "Henk Jandeberg");

        Invoice invoice = new Invoice("Factuur 4522", amount, "inforgraphic");

        try {
            PdfService.getInstance().generateInvoicePdf(invoice);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }


    public void clickOnReports(){
        controller.getRouter().nav("reports/1");
    }


}
