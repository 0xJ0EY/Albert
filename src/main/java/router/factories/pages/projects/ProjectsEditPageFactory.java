package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import albert.views.ProjectsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

public class ProjectsEditPageFactory implements EditPageFactory {

    @Override
    public EditPage create() {
        return new ProjectsController(new ProjectsEditView(), new MenuTemplateController());
    }
}
