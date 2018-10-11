package router.factories.pages.projects;

import albert.controllers.PageController;
import albert.controllers.pages.ProjectsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.pages.ProjectsDetailView;
import router.factories.pages.PageFactory;

public class ProjectsDetailPageFactory implements PageFactory {

    @Override
    public PageController create() {
        return new ProjectsController(new ProjectsDetailView(), new MenuTemplateController());
    }

}
