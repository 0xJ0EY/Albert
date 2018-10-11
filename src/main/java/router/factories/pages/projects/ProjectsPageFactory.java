package router.factories.pages.projects;

import albert.controllers.PageController;
import albert.controllers.pages.ProjectsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.pages.ProjectsView;
import router.factories.pages.PageFactory;

public class ProjectsPageFactory implements PageFactory {

    @Override
    public PageController create() {
        return new ProjectsController(new ProjectsView(), new MenuTemplateController());
    }

}
