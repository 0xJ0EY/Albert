package router;

import albert.Client;
import albert.controllers.pages.HomePage;
import albert.controllers.pages.ProjectsDetailPage;
import albert.controllers.pages.ProjectsPage;
import albert.controllers.templates.MenuTemplate;
import albert.views.pages.HomeView;
import albert.views.pages.ProjectsDetailView;
import albert.views.pages.ProjectsView;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import router.action.PageAction;
import router.response.Response;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(ApplicationExtension.class)
public class RouterTest {

    private Router router;

    @Start
    void onStart(Stage stage) throws Exception {

    }

    @BeforeEach
    void setupEach() {
        // Make a new router
        this.router = new Router(new Client());

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

    }

    @Test
    void unknownRoute() {
        Response response = this.router.navigate("/");

        assertNull(response);
    }

    @Test
    void routeHome() {
        Response response = this.router.navigate("home/");

        assertNotNull(response);
    }

    @Test
    void routeHomeTrailingSlash() {
        Response response = this.router.navigate("projects/1/");

        assertNotNull(response);
    }

}
