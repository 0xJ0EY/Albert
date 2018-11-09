package router.action;

import router.Request;
import router.Router;
import router.response.Response;
// TODO: Auto-generated Javadoc

/**
 * The Interface Action.
 * @author
 */
/*
Hier worden de acties behandeld.
 */
public interface Action {

    /**
     * Execute.
     *
     * @param router the router
     * @param request the request
     * @return the response
     */
    public Response execute(Router router, Request request);

}
