package router.factories.pages.Quotations;

import albert.controllers.QuotationsController;
import albert.views.QuotationsDetailView;
import router.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import router.factories.pages.DetailPageFactory;

/**
 * A factory for creating QuotationsDetailPage objects.
 *
 */
public class QuotationsDetailPageFactory implements DetailPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public DetailPage create() {
        return new QuotationsController(new QuotationsDetailView(), new MenuTemplateController());
    }

}
