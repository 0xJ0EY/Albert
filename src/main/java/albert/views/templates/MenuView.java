package albert.views.templates;

import albert.components.ActionTemplateButton;
import albert.controllers.HomeController;
import albert.controllers.PageController;
import albert.views.HomeView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import router.Router;
import router.action.TemplateAction;
import router.templates.TemplateController;
import router.views.PageView;
import router.views.TemplateView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MenuView extends AnchorPane implements TemplateView {

    @FXML private AnchorPane page;

    private final String resource = "/views/templates/Menu.fxml";
    private TemplateController controller;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private VBox actionContainer;

    @Override
    public void load() {

        // Load from FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {

        this.updateHistoryButtons();

        // Fetch the view of the page
        PageView pageView = this.controller.getPage().getView();

        // Update the view before rendering it
        pageView.update();

        // Render the page
        AnchorPane panel = pageView.render();

        // Anchor the panel to the sides of the parent AnchorPane
        AnchorPane.setTopAnchor(panel, 0d);
        AnchorPane.setBottomAnchor(panel, 0d);
        AnchorPane.setLeftAnchor(panel, 0d);
        AnchorPane.setRightAnchor(panel, 0d);

        this.page.getChildren().setAll(panel);

        this.updateActions();
    }

    private void updateActions() {

        HashMap<String, TemplateAction> actions = this.controller.getActions();

        Iterator it = actions.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            ActionTemplateButton btn = new ActionTemplateButton(
                (String) pair.getKey(),
                (TemplateAction) pair.getValue()
            );

            this.actionContainer.getChildren().add(btn);

            it.remove();
        }

    }


    private void updateHistoryButtons() {
        this.updateNextButton();
        this.updateBackButton();
    }

    private void updateBackButton() {
        Router router = this.controller.getRouter();
        this.backButton.setDisable( ! router.hasPrevious());
    }

    private void updateNextButton() {
        Router router = this.controller.getRouter();
        this.nextButton.setDisable( ! router.hasNext());
    }


    @Override
    public void setController(TemplateController controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        return this;
    }

    public void onClickHomeButton(){
        controller.getRouter().nav("home/");
    }

    public void onClickBackButton() {
        Router router = this.controller.getRouter();
        router.navToPrevious();
    }

    public void onClickNextButton() {
        Router router = this.controller.getRouter();
        router.navToNext();
    }

    public void clickOnProjects(){
        controller.getRouter().nav("projects/");
    }

    public void clickOnInvoices(){
        controller.getRouter().nav("invoices/");
    }

    public void clickOnExpenses(){
        controller.getRouter().nav("expenses/");
    }

    public void clickOnContacts()
    {
        controller.getRouter().nav("contacts/");
    }

    public void clickOnSettings(){
        controller.getRouter().nav("settings/");
    }

    public void clickOnQuotations(){
        controller.getRouter().nav("quotations/");
    }
}
