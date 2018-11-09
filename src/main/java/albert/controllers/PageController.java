package albert.controllers;

import router.pages.Page;
import router.templates.TemplateController;
import router.views.PageView;
import router.Router;
import table.Table;

// TODO: Auto-generated Javadoc
/*
De abstracte klas Page controller zorgt voor de juiste view voor elk geslecteerd pagina
 */

/**
 * The Class PageController.
 * @author
 */
public abstract class PageController implements Page {

    /** The template. */
    protected TemplateController template;
    
    /** The view. */
    protected PageView view;
    
    /** The router. */
    protected Router router;

    /**
     * Instantiates a new page controller.
     *
     * @param view the view
     * @param template the template
     */
    public PageController(
            PageView view,
            TemplateController template
    ) {
        this.setView(view);
        this.setTemplate(template);
    }

    /**
     * Sets the template.
     *
     * @param template the new template
     */
    private void setTemplate(TemplateController template) {
        this.template = template;
        this.template.setPage(this);
    }

    /**
     * Sets the view.
     *
     * @param view the new view
     */
    private void setView(PageView view) {
        this.view = view;
        this.view.setController(this);
        this.view.load();
    }

    /* (non-Javadoc)
     * @see router.pages.Page#getTemplate()
     */
    public TemplateController getTemplate() {
        return this.template;
    }

    /* (non-Javadoc)
     * @see router.pages.Page#getView()
     */
    public PageView getView() {
        return this.view;
    }

    /* (non-Javadoc)
     * @see router.pages.Page#setRouter(router.Router)
     */
    public void setRouter(Router router) {
        this.router = router;
    }

    /* (non-Javadoc)
     * @see router.pages.Page#getRouter()
     */
    public Router getRouter() {
        return this.router;
    }

}
