package router.action;

import router.pages.EditPage;
import router.Request;
import router.Router;
import router.factories.pages.EditPageFactory;
import router.response.Response;
// TODO: Auto-generated Javadoc

/**
 * The Class EditPageAction.
 * @author
 */
/*
Hier wordt de pagina getoont na het update.
 */
public class EditPageAction implements Action {

    /** The factory. */
    private EditPageFactory factory;

    /**
     * Instantiates a new edits the page action.
     *
     * @param factory the factory
     */
    public EditPageAction(EditPageFactory factory) {
        this.factory = factory;
    }

    /* (non-Javadoc)
     * @see router.action.Action#execute(router.Router, router.Request)
     */
    @Override
    public Response execute(Router router, Request request) {
        EditPage page = this.factory.create();

        page.setRouter(router);
        return page.edit(request);
    }

}
