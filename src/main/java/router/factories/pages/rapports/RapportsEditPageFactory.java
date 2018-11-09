package router.factories.pages.rapports;

import albert.controllers.RapportsController;
import albert.views.RapportsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

/**
 * A factory for creating RapportsEditPage objects.
 *
 */
public class RapportsEditPageFactory implements EditPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public EditPage create() {
        return new RapportsController(new RapportsEditView(), new MenuTemplateController());
    }
}
