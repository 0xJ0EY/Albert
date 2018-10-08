package albert;

import albert.controllers.PageController;
import albert.controllers.TemplateController;
import albert.controllers.pages.HomePage;
import albert.controllers.pages.ProjectsDetailPage;
import albert.controllers.pages.ProjectsPage;
import albert.controllers.templates.MenuTemplate;
import config.Config;
import config.ConfigManager;
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
        router.addRoute(new Route("projects/{test}/"), new PageAction(new ProjectsPage(new MenuTemplate())));
        router.addRoute(new Route("projects/details/{test}/"), new PageAction(new ProjectsDetailPage(new MenuTemplate())));

        this.stage = stage;

        this.router.nav("projects/details/test/");

        this.stage.show();
    }

    public void renderPage(PageController page) {
        this.stage.setScene(new Scene(page.getTemplate().render()));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
