package router.error_pages.views;

import albert.controllers.PageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import router.views.PageView;

/*
Hier wordt de error view getoont zodra er een fout in staat.
*/

public class NotFoundView extends AnchorPane implements PageView {
    private final String resource = "/views/error_pages/PageNotFound.fxml";
    private PageController controller;

    @Override
    /*
Dit methode zorgt dat het programma naar pageNotfound pagina gaat, als er een fout in staat
 */

    public void load() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void setController(PageController controller) {
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

}
