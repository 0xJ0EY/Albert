package albert;

import albert.controllers.PageController;
import config.Config;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import router.Router;
/*
Dat is het begin van de App, waar de stage start en gekopeld aan de router.
 */
public class Client extends Application {

    private Stage stage;

    private Router router = new Router(this);

    @Override
    public void start(Stage stage) throws Exception {

            this.stage = stage;

            // Set application title
            this.stage.setTitle(Config.get("config", "application.name"));

            this.router.nav("home/");

    }

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

    public static void main(String[] args) {
        launch(args);
    }

    private void setIcon() {

    }

}
