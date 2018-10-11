package albert.controllers;

import albert.views.PageView;
import javafx.scene.layout.AnchorPane;
import router.Request;
import router.Router;
import router.response.Response;

public interface PageController {

    public void setTemplate(TemplateController template);

    public void setRouter(Router router);

    public Router getRouter();

    public TemplateController getTemplate();

    public PageView getView();

    /**
     * In the request method we can start loading the objects required
     * for viewing the page.
     *
     * @author Joey de Ruiter
     * @param request
     * @return
     */
    public Response request(Request request);

}
