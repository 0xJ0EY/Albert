package albert.views;

import albert.controllers.ContactController;
import albert.controllers.PageController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import router.views.PageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import table.Table;
import table.views.TableView;


// TODO: Auto-generated Javadoc
/**
 * The Class ContactsView.
 * @author
 */
public class ContactsView extends AnchorPane implements PageView {

    /** The resource. */
    private final String resource = "/views/pages/ContactView.fxml";
    
    /** The controller. */
    private ContactController controller;

    /** The overview table. */
    @FXML
    private AnchorPane overviewTable;

    /** The search. */
    @FXML
    private TextField search;

    /* (non-Javadoc)
     * @see router.views.PageView#load()
     */
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

    /* (non-Javadoc)
     * @see router.views.PageView#update()
     */
    @Override
    public void update() {

        this.controller.getTemplate().addAction(
            "Nieuwe contact",
            () -> controller.getRouter().nav("contacts/create/")
        );

        Table table = controller.getOverviewTable();

        table.fetch();

        table.update();

        TableView tableView = table.getView();

        AnchorPane view = tableView.render();

        AnchorPane.setRightAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);

        this.overviewTable.getChildren().add(view);

    }

    /* (non-Javadoc)
     * @see router.views.PageView#setController(albert.controllers.PageController)
     */
    @Override
    public void setController(PageController controller) {
        this.controller = (ContactController) controller;
    }

    /* (non-Javadoc)
     * @see router.views.PageView#render()
     */
    @Override
    public AnchorPane render() {
        return this;
    }

    /**
     * On click add contact.
     */
    @FXML
    public void onClickAddContact(){
        controller.getRouter().nav("contacts/create/");
    }


}
