package router.factories.pages.Quotations;

import albert.controllers.QuotationsController;
import albert.views.QuotationsView;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import router.factories.pages.OverviewPageFactory;

public class QuotationsPageFactory implements OverviewPageFactory {

    @Override
    public OverviewPage create() {
        return new QuotationsController(new QuotationsView(), new MenuTemplateController());
    }

}
