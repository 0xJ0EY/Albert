package router.factories.pages.settings;

import albert.controllers.SettingsController;
import albert.views.SettingsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

/**
 * A factory for creating SettingsEditPage objects.
 *
 */
public class SettingsEditPageFactory implements EditPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public EditPage create() {
        return new SettingsController(new SettingsEditView(), new MenuTemplateController());
    }
}
