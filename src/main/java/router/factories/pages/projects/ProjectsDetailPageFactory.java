package router.factories.pages.projects;

import albert.controllers.PageController;
import albert.controllers.pages.projects.ProjectsDetailPage;
import albert.controllers.templates.MenuTemplate;
import albert.views.pages.ProjectsDetailView;
import router.factories.pages.PageFactory;

public class ProjectsDetailPageFactory implements PageFactory {

    @Override
    public PageController create() {
        return new ProjectsDetailPage(new ProjectsDetailView(), new MenuTemplate());
    }

}
