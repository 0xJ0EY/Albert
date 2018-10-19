package albert.views;

import albert.controllers.PageController;
import javafx.fxml.FXML;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ContactsView extends AnchorPane implements PageView {

    private final String resource = "/views/pages/ContactView.fxml";
    private PageController controller;

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
    public void setController(PageController controller) {
        this.controller = controller;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickEditContact(){
        controller.getRouter().nav("contacts/edit/{contacts}/");
    }

    @FXML
    public void onClickAddContact(){
        controller.getRouter().nav("contacts/add/{contacts}/");
    }


}