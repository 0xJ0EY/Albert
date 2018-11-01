package router.factories.pages.projects;


import albert.controllers.ContactController;
import albert.controllers.ProjectsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ContactCreateView;
import albert.views.ProjectsCreateView;
import albert.views.ProjectsView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

public class ProjectsCreatePageFactory implements CreatePageFactory {
    @Override
    public CreatePage create() {
        return new ProjectsController(new ProjectsCreateView(), new MenuTemplateController());

    }

}
