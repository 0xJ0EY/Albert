package router.factories.pages.expenses;

import albert.controllers.ExpenseController;
import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ExpenseEditView;
import albert.views.RapportsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;

public class ExpenseEditPageFactory implements EditPageFactory {

    @Override
    public EditPage create() {
        return new ExpenseController(new ExpenseEditView(), new MenuTemplateController());
    }
}
