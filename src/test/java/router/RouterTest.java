package router;

import albert.controllers.ProjectsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ProjectsView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import router.action.OverviewPageAction;
import router.factories.pages.home.HomePageFactory;
import router.response.Response;
import router.response.ViewResponse;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is a test for testing the routing functionality
 *
 */
@ExtendWith(ApplicationExtension.class)
public class RouterTest {

    private Router router;

    /**
     * Create a new router for every test,
     * this router will have the default routes from the RouteFactoryBuilder
     */
    @BeforeEach
    void setupEach() {
        this.router = new Router(null);
    }

    @Test
    void normalRouteTest() {
        // We use the home page as default routing test
        this.router.addRoute(new Route("test/"), new OverviewPageAction(new HomePageFactory()));

        Response response = this.router.navigate("test/");

        assertTrue(response instanceof ViewResponse);
    }

    @Test
    void paramRouteTest() {
        // We use the home page as default routing test
        this.router.addRoute(new Route("test/{param}/"), new OverviewPageAction(new HomePageFactory()));

        Response response = this.router.navigate("test/test/");

        assertTrue(response instanceof ViewResponse);
    }

    @Test
    void trailingSlashTest() {
        // We use the home page as default routing test
        this.router.addRoute(new Route("test/"), new OverviewPageAction(new HomePageFactory()));

        Response response = this.router.navigate("test");

        assertTrue(response instanceof ViewResponse);
    }

    @Test
    void paramTrailingSlashTest() {
        // We use the home page as default routing test
        this.router.addRoute(new Route("test/{param}/"), new OverviewPageAction(new HomePageFactory()));

        Response response = this.router.navigate("test/test");

        assertTrue(response instanceof ViewResponse);
    }

    @Test
    void lambdaRouteTest() {

        this.router.addRoute(new Route("test/{param}/"), new OverviewPageAction(() -> {
                return new ProjectsController(new ProjectsView(), new MenuTemplateController());
            })
        );

        Response response = this.router.navigate("test/test");

        assertTrue(response instanceof ViewResponse);
    }

}
