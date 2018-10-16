package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ProjectsView;
import router.factories.pages.OverviewPageFactory;

public class ProjectsPageFactory implements OverviewPageFactory {

    @Override
    public OverviewPage create() {
        return new ProjectsController(new ProjectsView(), new MenuTemplateController());
    }

}
