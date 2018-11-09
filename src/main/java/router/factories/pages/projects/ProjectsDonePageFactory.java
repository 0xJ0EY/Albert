package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ProjectsDoneView;
import albert.views.ProjectsView;
import router.factories.pages.OverviewPageFactory;
import router.pages.OverviewPage;

/**
 * A factory for creating ProjectsDonePage objects.
 *
 */
public class ProjectsDonePageFactory implements OverviewPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public OverviewPage create() {
        return new ProjectsController(new ProjectsDoneView(), new MenuTemplateController());
    }

}
