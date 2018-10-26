package router.action;

import router.Request;
import router.Router;
import router.response.Response;
/*
Hier worden de acties behandeld.
 */
public interface Action {

    public Response execute(Router router, Request request);

}
