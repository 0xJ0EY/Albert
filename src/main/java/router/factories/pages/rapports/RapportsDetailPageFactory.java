package router.factories.pages.rapports;

import albert.controllers.RapportsController;
import albert.views.RapportsDetailView;
import router.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import router.factories.pages.DetailPageFactory;

/**
 * A factory for creating RapportsDetailPage objects.
 *
 */
public class RapportsDetailPageFactory implements DetailPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public DetailPage create() {
        return new RapportsController(new RapportsDetailView(), new MenuTemplateController());
    }

}
