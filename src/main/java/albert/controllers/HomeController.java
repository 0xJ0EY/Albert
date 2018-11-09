package albert.controllers;

import query.Query;
import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;
import table.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 * @author
 */
public class HomeController extends PageController implements OverviewPage, DetailPage {

    /**
     * Instantiates a new home controller.
     *
     * @param view the view
     * @param template the template
     */
    public HomeController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    /* (non-Javadoc)
     * @see router.pages.OverviewPage#overview(router.Request)
     */
    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

    /* (non-Javadoc)
     * @see router.pages.DetailPage#detail(router.Request)
     */
    @Override
    public Response detail(Request request) {
        return new ViewResponse(this);
    }

}
