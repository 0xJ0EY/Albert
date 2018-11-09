package albert.controllers;

import router.Request;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;

// TODO: Auto-generated Javadoc
/**
 * The Class SettingsController.
 * @author
 */
public class SettingsController extends PageController implements OverviewPage, EditPage {


    /**
     * Instantiates a new settings controller.
     *
     * @param view the view
     * @param template the template
     */
    public SettingsController(PageView view, TemplateController template) {

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
     * @see router.pages.EditPage#edit(router.Request)
     */
    @Override
    public Response edit(Request request) {
        return new ViewResponse(this);
    }

}
