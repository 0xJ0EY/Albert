package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import albert.controllers.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.pages.ProjectsView;
import router.factories.PageFactory;
import router.factories.pages.OverviewPageFactory;

public class ProjectsPageFactory implements OverviewPageFactory {

    @Override
    public OverviewPage create() {
        return new ProjectsController(new ProjectsView(), new MenuTemplateController());
    }

}
