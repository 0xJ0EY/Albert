package router.factories.pages.projects;


import albert.controllers.ContactController;
import albert.controllers.ProjectsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ContactCreateView;
import albert.views.ProjectsCreateView;
import albert.views.ProjectsView;
import router.factories.pages.CreatePageFactory;
import router.pages.CreatePage;

/**
 * A factory for creating ProjectsCreatePage objects.
 *
 */
public class ProjectsCreatePageFactory implements CreatePageFactory {
    
    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public CreatePage create() {
        return new ProjectsController(new ProjectsCreateView(), new MenuTemplateController());

    }

}
