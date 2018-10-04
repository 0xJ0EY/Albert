package albert.views.templates;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.views.TemplateView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuView extends AnchorPane implements TemplateView {

    @FXML private AnchorPane page;

    private final String resource = "/views/templates/Menu.fxml";
    private TemplateController controller;

    @Override
    public void load(PageController page) {

        // Load from FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        AnchorPane panel = page.render();

        // Anchor the panel to the sides of the parent AnchorPane
        AnchorPane.setTopAnchor(panel, 0d);
        AnchorPane.setBottomAnchor(panel, 0d);
        AnchorPane.setLeftAnchor(panel, 0d);
        AnchorPane.setRightAnchor(panel, 0d);

        this.page.getChildren().setAll(panel);
    }

    @Override
    public void setController(TemplateController controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        return this;
    }
}