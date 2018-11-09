package router.action;

import router.Request;
import router.Router;
import router.response.Response;

/**
 * The Interface Action. This handles the actions
 *
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
