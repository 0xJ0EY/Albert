package albert;

import albert.controllers.PageController;
import albert.controllers.pages.HomePage;
import albert.controllers.pages.ProjectsDetailPage;
import albert.controllers.pages.ProjectsPage;
import albert.controllers.templates.MenuTemplate;
import albert.views.pages.HomeView;
import albert.views.pages.ProjectsDetailView;
import albert.views.pages.ProjectsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import router.Route;
import router.Router;
import router.action.PageAction;

public class Client extends Application {

    private Stage stage;

    private Router router = new Router(this);

    @Override
    public void start(Stage stage) throws Exception {

        // Populate the router
        router.addRoute(
                new Route("home/"),
                new PageAction(
                        new HomePage(
                                new HomeView(),
                                new MenuTemplate(),
                                this.router
                        )
                )
        );

        router.addRoute(
                new Route("projects/{page}/"),
                new PageAction(
                        new ProjectsPage(
                                new ProjectsView(),
                                new MenuTemplate(),
                                this.router
                        )
                )
        );

        router.addRoute(
                new Route("projects/details/{test}/"),
                new PageAction(
                        new ProjectsDetailPage(
                                new ProjectsDetailView(),
                                new MenuTemplate(),
                                this.router
                        )
                )
        );

        this.stage = stage;

        this.router.nav("projects/details/1/");

        this.stage.show();
    }

    public void renderPage(PageController page) {
        this.stage.setScene(
            new Scene(
                page.getTemplate().render(),
                this.stage.getWidth(),
                this.stage.getHeight()
            )
        );
    }

    public static void main(String[] args) {
        launch(args);
    }

}
