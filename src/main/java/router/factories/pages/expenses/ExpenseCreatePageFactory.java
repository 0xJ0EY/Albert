package router.factories.pages.expenses;

import albert.controllers.ExpenseController;
import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ExpenseCreateView;
import albert.views.RapportsCreateView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

/**
 * A factory for creating ExpenseCreatePage objects.
 */
public class ExpenseCreatePageFactory implements CreatePageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public CreatePage create() {
        return new ExpenseController(new ExpenseCreateView(), new MenuTemplateController());
    }
}
