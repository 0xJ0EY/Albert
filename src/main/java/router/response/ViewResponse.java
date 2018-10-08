package router.response;

import albert.controllers.PageController;
import router.Router;

public class ViewResponse implements Response {

    private PageController controller;

    public ViewResponse(PageController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(Router router) {
        router.getClient().renderPage(this.controller);
    }
}
