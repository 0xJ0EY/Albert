package router.action;

import router.pages.DetailPage;
import router.Request;
import router.Router;
import router.factories.pages.DetailPageFactory;
import router.response.Response;


/**
 * The Class DetailPageAction. Creates an DetailPageAction based on action
 *
 */
public class DetailPageAction implements Action {

    /** The factory. */
    private DetailPageFactory factory;

    /**
     * Instantiates a new detail page action.
     *
     * @param factory the factory
     */
    public  DetailPageAction(DetailPageFactory factory) {
        this.factory = factory;
    }

    /* (non-Javadoc)
     * @see router.action.Action#execute(router.Router, router.Request)
     */
    @Override
    public Response execute(Router router, Request request) {
        DetailPage page = this.factory.create();

        page.setRouter(router);
        return page.detail(request);
    }

}
