package router.action;

import router.Request;
import router.Router;
import router.response.Response;

public interface Action {

    public Response execute(Router router, Request request);

}
