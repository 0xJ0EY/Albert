package albert.controllers;

import albert.dao.ContactDAO;
import albert.dao.DAO;
import albert.models.Contact;
import router.pages.CreatePage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;

public class ContactController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage, CreateObject {

    private ContactDAO dao = new ContactDAO();
    public ContactController(
            PageView view,
            TemplateController template
    ) {
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

    @Override
    public Response create(Request request) {

        return new ViewResponse(this);
    }
    
    @Override
    public void createObj(Object obj) {
        dao.create((Contact)obj);
    }
}
