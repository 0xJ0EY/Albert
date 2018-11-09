package albert;

import albert.controllers.PageController;
import config.Config;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import router.Router;

/**
 * The Class Client. Her it starts the application
 *
 */

public class Client extends Application {

    /** The stage. */
    private Stage stage;

    /** The router. */
    private Router router = new Router(this);

    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) throws Exception {

            this.stage = stage;

            // Set application title
            this.stage.setTitle(Config.get("config", "application.name"));

            this.router.nav("home/");

    }

    /**
     * Render page.
     *
     * @param page the page
     */
    public void renderPage(PageController page) {

        Scene previousScene = this.stage.getScene();

        double width = Double.valueOf(Config.get("config", "client.width"));
        double height = Double.valueOf(Config.get("config", "client.height"));

        if (previousScene != null) {
            width = previousScene.getWidth();
            height = previousScene.getHeight();
        }

        Scene scene = new Scene(
            page.getTemplate().render(),
            width,
            height
        );

        //css styling
        scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());

        this.stage.setScene(scene);

        this.stage.show();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Show warning.
     *
     * @param title the title
     * @param message the message
     */
    public static void ShowWarning(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

}
