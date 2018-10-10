package router.factories;

import router.Route;
import router.action.Action;
import router.action.PageAction;
import router.factories.pages.home.HomePageFactory;
import router.factories.pages.projects.ProjectsDetailPageFactory;
import router.factories.pages.projects.ProjectsPageFactory;

import java.util.HashMap;

public class RouteFactoryBuilder {

    public HashMap<Route, Action> create() {
        HashMap<Route, Action> map = new HashMap<>();

        // Home
        map.put(new Route("home/"), new PageAction(new HomePageFactory()));

        // Projects
        map.put(new Route("projects/{page}/"), new PageAction(new ProjectsPageFactory()));
        map.put(new Route("projects/details/{project}/"), new PageAction(new ProjectsDetailPageFactory()));

        return map;
    }

}
