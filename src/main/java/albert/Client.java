package albert;

import albert.controllers.PageController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import router.Router;

public class Client extends Application {

    private Stage stage;

    private Router router = new Router(this);

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        this.router.nav("home/");

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
