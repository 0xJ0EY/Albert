package router;

import database.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import router.response.Response;
import router.response.ViewResponse;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class specialised in testing all the available routes
 */
@ExtendWith(ApplicationExtension.class)
public class RouteTest {

    private Router router;

    @BeforeAll
    static void setup() {
        // Setup database pooling
        Database db = Database.getInstance();

        // Get a test connection
        Connection conn = db.getConnection();

        // Close test connection
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeEach
    void setupEach() {
        this.router = new Router(null);
    }

    @Test
    void homeTest() {
        Response response = this.router.navigate("home/");

        assertTrue(response instanceof ViewResponse);
    }

    @Test
    void projectsTest() {
        Response response = this.router.navigate("projects/");

        assertTrue(response instanceof ViewResponse);
    }

    @Test
    void projectsDetailTest() {
        Response response = this.router.navigate("projects/details/1/");

        assertTrue(response instanceof ViewResponse);
    }

}
