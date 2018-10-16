package router.pages;

import router.Request;
import router.response.Response;

public interface CreatePage extends Page {

    public Response create(Request request);

}
