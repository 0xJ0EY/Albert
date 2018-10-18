package router.factories.pages.settings;

import albert.controllers.RapportsController;
import albert.controllers.SettingsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.RapportsView;
import albert.views.SettingsView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

public class SettingsPageFactory implements OverviewPageFactory {
    @Override
    public OverviewPage create() {
        return new SettingsController( new SettingsView(), new MenuTemplateController());
    }
}
