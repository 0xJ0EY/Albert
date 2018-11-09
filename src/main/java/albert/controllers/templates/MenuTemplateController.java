package albert.controllers.templates;

import albert.controllers.PageController;
import router.Router;
import router.action.TemplateAction;
import router.pages.Page;
import router.views.TemplateView;
import albert.views.templates.MenuView;
import javafx.scene.Parent;
import router.templates.TemplateController;

import java.util.HashMap;

/**
 * The Class MenuTemplateController.
 * Create the MenuTemplate
 *
 */
public class MenuTemplateController implements TemplateController {

    /** The view. */
    private TemplateView view = new MenuView();
    
    /** The page. */
    private PageController page;
    
    /** The router. */
    protected Router router;

    /** The actions. */
    protected HashMap<String, TemplateAction> actions = new HashMap<>();

    /* (non-Javadoc)
     * @see router.templates.TemplateController#setPage(albert.controllers.PageController)
     */
    @Override
    public void setPage(PageController page) {
        this.page = page;
        this.view.setController(this);
        this.view.load();
    }

    /* (non-Javadoc)
     * @see router.templates.TemplateController#getPage()
     */
    @Override
    public PageController getPage() {
        return this.page;
    }

    /* (non-Javadoc)
     * @see router.templates.TemplateController#render()
     */
    @Override
    public Parent render() {

        this.view.update();

        return this.view.render();
    }

    /* (non-Javadoc)
     * @see router.templates.TemplateController#getRouter()
     */
    @Override
    public Router getRouter() {
        return page.getRouter();
    }

    /* (non-Javadoc)
     * @see router.templates.TemplateController#addAction(java.lang.String, router.action.TemplateAction)
     */
    @Override
    public void addAction(String name, TemplateAction templateAction) {
        this.actions.put(name, templateAction);
    }

    /* (non-Javadoc)
     * @see router.templates.TemplateController#getActions()
     */
    @Override
    public HashMap<String, TemplateAction> getActions() {
        return this.actions;
    }
}
