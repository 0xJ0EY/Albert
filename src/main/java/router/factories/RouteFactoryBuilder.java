package router.factories;

import albert.controllers.templates.MenuTemplateController;
import router.Route;
import router.action.Action;
import router.action.DetailPageAction;
import router.action.OverviewPageAction;
import router.error_pages.ErrorController;
import router.error_pages.views.NotFoundView;
import router.factories.pages.home.HomePageFactory;
import router.factories.pages.projects.ProjectsDetailPageFactory;
import router.factories.pages.projects.ProjectsPageFactory;

import java.util.HashMap;

public class RouteFactoryBuilder {

    public HashMap<Route, Action> routes() {
        HashMap<Route, Action> map = new HashMap<>();

        // Home
        map.put(new Route("home/"), new OverviewPageAction(new HomePageFactory()));

        // Projects
        map.put(new Route("projects/{page}/"), new OverviewPageAction(new ProjectsPageFactory()));
        map.put(new Route("projects/details/{project}/"), new DetailPageAction(new ProjectsDetailPageFactory()));

        // Errors
        map.put(new Route("errors/404"), new OverviewPageAction(() -> {
            return new ErrorController(new NotFoundView(), new MenuTemplateController());
        }));

        return map;
    }

}
