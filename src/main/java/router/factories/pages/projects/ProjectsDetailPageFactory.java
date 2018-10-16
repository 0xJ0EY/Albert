package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import router.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ProjectsDetailView;
import router.factories.pages.DetailPageFactory;

public class ProjectsDetailPageFactory implements DetailPageFactory {

    @Override
    public DetailPage create() {
        return new ProjectsController(new ProjectsDetailView(), new MenuTemplateController());
    }

}
