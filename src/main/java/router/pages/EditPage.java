package router.pages;

import router.Request;
import router.response.Response;

public interface EditPage extends Page {

    public Response edit(Request request);

}
