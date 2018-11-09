package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import albert.views.ProjectsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ProjectsEditPage objects.
 * @author
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
