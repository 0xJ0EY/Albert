package router.factories.pages.projects;

import albert.controllers.PageController;
import albert.controllers.pages.projects.ProjectsPage;
import albert.controllers.templates.MenuTemplate;
import albert.views.pages.ProjectsView;
import router.factories.pages.PageFactory;

public class ProjectsPageFactory implements PageFactory {

    @Override
    public PageController create() {
        return new ProjectsPage(new ProjectsView(), new MenuTemplate());
    }

}
