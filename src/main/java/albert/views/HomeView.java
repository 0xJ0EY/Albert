package albert.views;

import albert.controllers.HomeController;
import albert.controllers.PageController;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class HomeView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/Home.fxml";
    private HomeController controller;

    @Override
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
    public void update() {
    }

    @Override
    public void setController(PageController controller) {
        this.controller = (HomeController) controller;
    }

    @Override
    public AnchorPane render() {

        this.controller.getOverviewTable().update();

//        this.controller.getOverviewTable().navigate(2);

        return this.controller.getOverviewTable().getView().render();
    }

}
