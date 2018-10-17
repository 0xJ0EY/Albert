package albert.controllers;

import router.pages.Page;
import router.templates.TemplateController;
import router.views.PageView;
import router.Router;

public abstract class PageController implements Page {

    protected TemplateController template;
    protected PageView view;
    protected Router router;

    public PageController(
            PageView view,
            TemplateController template
    ) {
        this.setView(view);
        this.setTemplate(template);
    }

    private void setTemplate(TemplateController template) {
        this.template = template;
        this.template.setPage(this);
    }

    private void setView(PageView view) {
        this.view = view;
        this.view.setController(this);
        this.view.load();
    }

    public TemplateController getTemplate() {
        return this.template;
    }

    public PageView getView() {
        return this.view;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public Router getRouter() {
        return this.router;
    }

}
