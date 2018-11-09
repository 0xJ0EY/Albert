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

/**
 * The Class HomeView. Loads the HomeView
 *
 */
public class HomeView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/Home.fxml";
    
    /** The controller. */
    private HomeController controller;

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

        this.controller.getTemplate().addAction("Projecten", () -> controller.getRouter().nav("projects/"));

        this.controller.getTemplate().addAction("Onkosten", () -> controller.getRouter().nav("expenses/"));

        this.controller.getTemplate().addAction("Facturen", () -> controller.getRouter().nav("invoices/"));

    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (HomeController) controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }


    /**
     * Click on projects.
     */
    public void clickOnProjects(){
        controller.getRouter().nav("projects/");
    }


    /**
     * Click on invoices.
     */
    public void clickOnInvoices(){
        controller.getRouter().nav("invoices/");
    }


    /**
     * Click on expenses.
     */
    public void clickOnExpenses(){
        controller.getRouter().nav("expenses/");
    }


}
