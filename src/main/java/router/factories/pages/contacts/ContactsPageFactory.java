package main.java.router.factories.pages.contacts;

public class ContactsPageFactory implements OverviewPageFactory {

    @Override
    public albert.controllers.PageController create() {
        return new albert.controllers.pages.home.HomePage(new albert.views.pages.HomeView(), new albert.controllers.templates.MenuTemplate());
    }

}
