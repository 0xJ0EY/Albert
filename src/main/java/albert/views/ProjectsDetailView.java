package albert.views;

import albert.controllers.PageController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
/*
Hier wordt de DetailView geladen
 */


public class ProjectsDetailView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ProjectsDetail.fxml";
    private PageController controller;

    @FXML
    private TextField searchBarQuotation;

    @FXML
    private TextField searchBarInvoice;

    @FXML
    private TextField searchBarCosts;

    @FXML
    private Button projectEdit;

    @FXML
    private Button projectDelete;

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
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }
}
