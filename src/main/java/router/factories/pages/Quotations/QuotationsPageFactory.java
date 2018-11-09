package router.factories.pages.Quotations;

import albert.controllers.QuotationsController;
import albert.views.QuotationsView;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import router.factories.pages.OverviewPageFactory;

/**
 * A factory for creating QuotationsPage objects.
 *
 */
public class QuotationsPageFactory implements OverviewPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new QuotationsController(new QuotationsView(), new MenuTemplateController());
    }

}
