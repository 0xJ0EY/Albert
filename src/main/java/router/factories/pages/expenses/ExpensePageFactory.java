package router.factories.pages.expenses;

import albert.controllers.ExpenseController;
import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ExpenseView;
import albert.views.RapportsView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

public class ExpensePageFactory implements OverviewPageFactory {
    @Override
    public OverviewPage create() {
        return new ExpenseController( new ExpenseView(), new MenuTemplateController());
    }
}
