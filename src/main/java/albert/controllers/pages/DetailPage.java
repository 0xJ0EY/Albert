package albert.controllers.pages;

import router.Request;
import router.response.Response;

public interface DetailPage extends Page {

    public Response detail(Request request);

}
