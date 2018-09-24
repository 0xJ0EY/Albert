package albert;

import albert.controllers.TemplateController;
import albert.controllers.pages.HomePage;
import albert.controllers.pages.ProductsPage;
import albert.controllers.templates.MenuTemplate;
import albert.views.pages.HomeView;
import albert.views.pages.ProductsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {

    private Stage stage;
    private TemplateController template;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        this.template = new MenuTemplate();
        this.template.setPage(new HomePage());

        Scene sceneA = new Scene(this.template.render());

        this.stage.setScene(sceneA);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
