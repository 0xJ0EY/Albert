package router.factories.pages.rapports;

import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.RapportsView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

/**
 * A factory for creating RapportsPage objects.
 *
 */
public class RapportsPageFactory implements OverviewPageFactory {
    
    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new RapportsController( new RapportsView(), new MenuTemplateController());
    }
}
