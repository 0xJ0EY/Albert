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

// TODO: Auto-generated Javadoc
/**
 * The Class MenuView.
 * @author
 */
public class MenuView extends AnchorPane implements TemplateView {

    /** The page. */
    @FXML private AnchorPane page;

    /** The resource. */
    private final String resource = "/views/templates/Menu.fxml";
    
    /** The controller. */
    private TemplateController controller;

    /** The back button. */
    @FXML
    private Button backButton;

    /** The next button. */
    @FXML
    private Button nextButton;

    /** The action container. */
    @FXML
    private VBox actionContainer;

    /* (non-Javadoc)
     * @see router.views.TemplateView#load()
     */
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

    /* (non-Javadoc)
     * @see router.views.TemplateView#update()
     */
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

    /**
     * Update actions.
     */
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


    /**
     * Update history buttons.
     */
    private void updateHistoryButtons() {
        this.updateNextButton();
        this.updateBackButton();
    }

    /**
     * Update back button.
     */
    private void updateBackButton() {
        Router router = this.controller.getRouter();
        this.backButton.setDisable( ! router.hasPrevious());
    }

    /**
     * Update next button.
     */
    private void updateNextButton() {
        Router router = this.controller.getRouter();
        this.nextButton.setDisable( ! router.hasNext());
    }


    /* (non-Javadoc)
     * @see router.views.TemplateView#setController(router.templates.TemplateController)
     */
    @Override
    public void setController(TemplateController controller) {
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see router.views.TemplateView#render()
     */
    @Override
    public Parent render() {
        return this;
    }

    /**
     * On click home button.
     */
    public void onClickHomeButton(){
        controller.getRouter().nav("home/");
    }

    /**
     * On click back button.
     */
    public void onClickBackButton() {
        Router router = this.controller.getRouter();
        router.navToPrevious();
    }

    /**
     * On click next button.
     */
    public void onClickNextButton() {
        Router router = this.controller.getRouter();
        router.navToNext();
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

    /**
     * Click on contacts.
     */
    public void clickOnContacts()
    {
        controller.getRouter().nav("contacts/");
    }

    /**
     * Click on settings.
     */
    public void clickOnSettings(){
        controller.getRouter().nav("settings/");
    }

    /**
     * Click on quotations.
     */
    public void clickOnQuotations(){
        controller.getRouter().nav("quotations/");
    }
}
