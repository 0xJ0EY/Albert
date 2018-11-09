package router.action;

import router.pages.DeletePage;
import router.Request;
import router.Router;
import router.factories.pages.DeletePageFactory;
import router.response.Response;
// TODO: Auto-generated Javadoc

/**
 * The Class DeletePageAction.
 * @author
 */
/*
Hier wordt een page verwijderd, op basis van een request
 */
public class DeletePageAction implements Action {

    /** The factory. */
    private DeletePageFactory factory;

    /**
     * Instantiates a new delete page action.
     *
     * @param factory the factory
     */
    public  DeletePageAction(DeletePageFactory factory) {
        this.factory = factory;
    }

    /* (non-Javadoc)
     * @see router.action.Action#execute(router.Router, router.Request)
     */
    @Override
    public Response execute(Router router, Request request) {
        DeletePage page = this.factory.create();

        page.setRouter(router);
        return page.delete(request);
    }
}
