package router.factories.pages.projects;

import albert.controllers.ProjectsController;
import router.pages.DetailPage;
import albert.controllers.templates.MenuTemplateController;
import albert.views.ProjectsDetailView;
import router.factories.pages.DetailPageFactory;

/**
 * A factory for creating ProjectsDetailPage objects.
 *
 */
public class ProjectsDetailPageFactory implements DetailPageFactory {

    /* (non-Javadoc)
     * @see router.factories.PageFactory#create()
     */
    @Override
    public DetailPage create() {
        return new ProjectsController(new ProjectsDetailView(), new MenuTemplateController());
    }

}
