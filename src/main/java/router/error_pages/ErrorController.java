package router.error_pages;

import albert.controllers.PageController;
import router.Request;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;

/**
 * The Class ErrorController.
 *
 */
public class ErrorController extends PageController implements OverviewPage {

    /**
     * Instantiates a new error controller.
     *
     * @param view the view
     * @param template the template
     */
    public ErrorController(PageView view, TemplateController template) {
        super(view, template);
    }

    /* (non-Javadoc)
     * @see router.pages.OverviewPage#overview(router.Request)
     */
    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

}
