package albert.controllers;

import router.Request;
import router.pages.DetailPage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;

import java.io.IOException;


public class InvoicesController extends PageController implements OverviewPage, DetailPage, EditPage {

    public InvoicesController(PageView view, TemplateController template) {
        super(view, template);
    }

    @Override
    public Response overview(Request request) {
        return new ViewResponse(this);
    }

    @Override
    public Response detail(Request request) {
        return new ViewResponse(this);
    }


    @Override
    public Response edit(Request request) {
        return new ViewResponse(this);
    }

}
