package router.factories.pages.expenses;

import albert.controllers.ExpenseController;
import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ExpenseEditView;
import albert.views.RapportsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;

/**
 * A factory for creating ExpenseEditPage objects.
 *
 */
public class ExpenseEditPageFactory implements EditPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public EditPage create() {
        return new ExpenseController(new ExpenseEditView(), new MenuTemplateController());
    }
}
