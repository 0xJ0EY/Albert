package albert;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.controllers.pages.HomePage;
import albert.controllers.pages.ProductsPage;
import albert.controllers.templates.MenuTemplate;
import albert.views.pages.HomeView;
import albert.views.pages.ProductsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import router.Route;
import router.Router;
import router.action.PageAction;

public class Client extends Application {

    private Stage stage;
    private TemplateController template;

    private Router router = new Router(this);

    @Override
    public void start(Stage stage) throws Exception {
        // Populate the router
        router.addRoute(new Route("home/"), new PageAction(new HomePage(new MenuTemplate())));
        router.addRoute(new Route("products/{holy_fuck}/"), new PageAction(new ProductsPage(new MenuTemplate())));

        this.stage = stage;

        this.router.nav("products/cool_shit/");

        this.stage.show();
    }

    public void renderPage(PageController page) {
        this.stage.setScene(new Scene(page.getTemplate().render()));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
