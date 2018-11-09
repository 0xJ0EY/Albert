package router.action;

import router.pages.OverviewPage;
import router.Request;
import router.Router;
import router.factories.pages.OverviewPageFactory;
import router.response.Response;

/**
 * The Class OverviewPageAction. Creates an OverviewPageAction based on action
 *
 */
public class OverviewPageAction implements Action {

    /** The factory. */
    private OverviewPageFactory factory;

    /**
     * Instantiates a new overview page action.
     *
     * @param factory the factory
     */
    public  OverviewPageAction(OverviewPageFactory factory) {
        this.factory = factory;
    }

    /* (non-Javadoc)
     * @see router.action.Action#execute(router.Router, router.Request)
     */
    @Override
    public Response execute(Router router, Request request) {
        OverviewPage page = this.factory.create();

        page.setRouter(router);
        return page.overview(request);
    }

}
