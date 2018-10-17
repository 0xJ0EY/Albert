package albert;

import albert.controllers.PageController;
import config.Config;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import router.Router;

public class Client extends Application {

    private Stage stage;

    private Router router = new Router(this);

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        // Set application title
        this.stage.setTitle(Config.get("config", "application.name"));

        this.router.nav("home");

        this.stage.show();
    }

    public void renderPage(PageController page) {

        Scene scene = new Scene(
            page.getTemplate().render(),
            this.stage.getWidth(),
            this.stage.getHeight()
        );

        scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());

        this.stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
