package router.factories.pages.expenses;

import albert.controllers.ExpenseController;
import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ExpenseDetailView;
import albert.views.RapportsDetailView;
import router.factories.pages.DetailPageFactory;
import router.pages.DetailPage;

/**
 * A factory for creating ExpenseDetailPage objects.
 *
 */
public class ExpenseDetailPageFactory implements DetailPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public DetailPage create() {
        return new ExpenseController(new ExpenseDetailView(), new MenuTemplateController());
    }

}
