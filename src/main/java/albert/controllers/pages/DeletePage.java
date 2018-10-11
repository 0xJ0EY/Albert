package albert.controllers.pages;

import router.Request;
import router.response.Response;

public interface DeletePage extends Page {

    public Response delete(Request request);

}
