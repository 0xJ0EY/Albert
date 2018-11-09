package router.factories.pages.rapports;

import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.RapportsCreateView;
import albert.views.RapportsEditView;
import router.factories.pages.CreatePageFactory;
import router.factories.pages.EditPageFactory;
import router.pages.CreatePage;
import router.pages.EditPage;

/**
 * A factory for creating RapportsCreatePage objects.
 *
 */
public class RapportsCreatePageFactory implements CreatePageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public CreatePage create() {
        return new RapportsController(new RapportsCreateView(), new MenuTemplateController());
    }
}
