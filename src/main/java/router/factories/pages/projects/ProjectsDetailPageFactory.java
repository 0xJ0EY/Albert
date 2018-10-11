package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import albert.controllers.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.pages.ProjectsDetailView;
import router.factories.PageFactory;
import router.factories.pages.DetailPageFactory;

public class ProjectsDetailPageFactory implements DetailPageFactory {

    @Override
    public DetailPage create() {
        return new ProjectsController(new ProjectsDetailView(), new MenuTemplateController());
    }

}
