package router.factories.pages.settings;

import albert.controllers.SettingsController;
import albert.views.SettingsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

public class SettingsEditPageFactory implements EditPageFactory {

    @Override
    public EditPage create() {
        return new SettingsController(new SettingsEditView(), new MenuTemplateController());
    }
}
