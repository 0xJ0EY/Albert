package router;

import albert.Client;
import albert.controllers.pages.HomePage;
import albert.controllers.pages.ProductsPage;
import albert.controllers.templates.MenuTemplate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import router.action.PageAction;
import router.response.Response;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouterTest {


    private Router router;

    @BeforeEach
    void setupEach() {
        // Make a new router
        this.router = new Router(new Client());

        this.router.addRoute(new Route("/home/"), new PageAction(new HomePage(new MenuTemplate())));
        this.router.addRoute(new Route("/products/{product}/"), new PageAction(new ProductsPage(new MenuTemplate())));
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
        Response response = this.router.navigate("/products/123");

        assertNotNull(response);
    }

}
