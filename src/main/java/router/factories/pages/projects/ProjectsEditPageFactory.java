package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import albert.views.ProjectsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

/**
 * A factory for creating ProjectsEditPage objects.
 *
 */
public class ProjectsEditPageFactory implements EditPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public EditPage create() {
        return new ProjectsController(new ProjectsEditView(), new MenuTemplateController());
    }
}
