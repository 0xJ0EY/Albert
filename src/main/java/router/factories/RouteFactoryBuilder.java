package router.factories;

import router.Route;
import router.action.Action;
import router.action.DetailPageAction;
import router.action.OverviewPageAction;
import router.factories.pages.contacts.ContactsPageFactory;
import router.factories.pages.home.HomePageFactory;
import router.factories.pages.projects.ProjectsDetailPageFactory;
import router.factories.pages.projects.ProjectsPageFactory;

import java.util.HashMap;

public class RouteFactoryBuilder {

    public HashMap<Route, Action> create() {
        HashMap<Route, Action> map = new HashMap<>();

        // Home
        map.put(new Route("home/"), new OverviewPageAction(new HomePageFactory()));

        // Projects
        map.put(new Route("projects/{page}/"), new OverviewPageAction(new ProjectsPageFactory()));
        map.put(new Route("projects/details/{project}/"), new DetailPageAction(new ProjectsDetailPageFactory()));
        map.put(new Route("projects/details/{project}/"), new OverviewPageAction(new ContactsPageFactory()));

        return map;
    }

}
