package router.response;

import albert.controllers.PageController;
import router.Router;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewResponse.
 *
 */
public class ViewResponse implements Response {

    /** The controller. */
    private PageController controller;

    /**
     * Instantiates a new view response.
     *
     * @param controller the controller
     */
    public ViewResponse(PageController controller) {
        this.controller = controller;
    }

    /* (non-Javadoc)
     * @see router.response.Response#execute(router.Router)
     */
    @Override
    public void execute(Router router) {
        router.getClient().renderPage(this.controller);
    }
}
