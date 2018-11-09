package router.factories.pages.home;

import albert.controllers.HomeController;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.HomeView;
import router.factories.pages.OverviewPageFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating HomePage objects.
 * @author
 */
public class HomePageFactory implements OverviewPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new HomeController(new HomeView(), new MenuTemplateController());
    }

}
