package router.factories.pages.Quotations;

import albert.controllers.ProjectsController;
import albert.controllers.QuotationsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ProjectsCreateView;
import albert.views.QuotationsCreateView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

/**
 * A factory for creating QuotationsCreatePage objects.
 *
 */
public class QuotationsCreatePageFactory implements CreatePageFactory {
    
    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public CreatePage create() {
        return new QuotationsController(new QuotationsCreateView(), new MenuTemplateController());

    }
}
