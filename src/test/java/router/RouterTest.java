package router;

import albert.Client;
import albert.controllers.pages.HomePage;
import albert.controllers.pages.ProjectsPage;
import albert.controllers.templates.MenuTemplate;
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

        this.router.addRoute(new Route("/home/"), new PageAction(new HomePage(new MenuTemplate())));
        this.router.addRoute(new Route("/projects/{project}/"), new PageAction(new ProjectsPage(new MenuTemplate())));
    }

    @Test
    void unknownRoute() {
        Response response = this.router.navigate("/");

        assertNull(response);
    }

    @Test
    void routeHome() {
        Response response = this.router.navigate("/home/");

        assertNotNull(response);
    }

    @Test
    void routeHomeTrailingSlash() {
        Response response = this.router.navigate("/projects/123/");

        System.out.println("response = " + response);

        assertNotNull(response);
    }

}
