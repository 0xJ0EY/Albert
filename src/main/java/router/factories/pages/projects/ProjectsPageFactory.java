package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import router.pages.OverviewPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ProjectsView;
import router.factories.pages.OverviewPageFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ProjectsPage objects.
 * @author
 */
public class ProjectsPageFactory implements OverviewPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new ProjectsController(new ProjectsView(), new MenuTemplateController());
    }

}
