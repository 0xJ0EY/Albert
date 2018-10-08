package albert.controllers;

import albert.views.PageView;
import javafx.scene.layout.AnchorPane;
import router.Request;
import router.Router;
import router.response.Response;

public interface PageController {

    public void setTemplate(TemplateController template);

    public TemplateController getTemplate();

    public void setView(PageView view);

    public AnchorPane render();

    /**
     * In the request method we can start loading the objects required
     * for viewing the page.
     *
     * @author Joey de Ruiter
     * @param router
     * @param request
     * @return
     */
    public Response request(Router router, Request request);

}
