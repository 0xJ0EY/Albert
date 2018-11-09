package router.action;

import router.pages.CreatePage;
import router.Request;
import router.Router;
import router.factories.pages.CreatePageFactory;
import router.response.Response;

/**
 * The Class CreatePageAction. Creates an CreatePageAction based on a action
 *
 */
public class CreatePageAction implements Action {

    /** The factory. */
    private CreatePageFactory factory;

    /**
     * Instantiates a new creates the page action.
     *
     * @param factory the factory
     */
    public  CreatePageAction(CreatePageFactory factory)
    {
        this.factory = factory;
    }

    /* (non-Javadoc)
     * @see router.action.Action#execute(router.Router, router.Request)
     */
    @Override
    public Response execute(Router router, Request request) {
        CreatePage page = this.factory.create();

        page.setRouter(router);
        return page.create(request);
    }

}
