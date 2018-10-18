package router.factories.pages.rapports;

import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.RapportsView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

public class RapportsPageFactory implements OverviewPageFactory {
    @Override
    public OverviewPage create() {
        return new RapportsController( new RapportsView(), new MenuTemplateController());
    }
}
