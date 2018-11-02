package albert.controllers;

import albert.dao.QuotationDAO;
import albert.models.Amount;
import albert.models.Quotation;
import router.Request;
import router.pages.CreatePage;
import router.pages.DetailPage;
import router.pages.EditPage;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;


public class QuotationsController extends PageController implements OverviewPage, DetailPage, EditPage, CreatePage {
    Amount amount;
    Quotation quotation;

    private QuotationDAO dao = new QuotationDAO();

    public QuotationsController(PageView view, TemplateController template) {
        super(view, template);
    }

    public void saveQuotation(String name, String price, String hour, String contact, String delivery) {
        amount = new Amount(new Double(price), new Double(hour), contact);
        quotation = new Quotation(name, amount, delivery);
        dao.create(quotation);
    }

    public void deleteQuotation() { dao.delete(quotation); }

    public void editQuotation(String name, String price, String hour, String contact, String delivery) {
        //amount = new Amount(new Double(price), new Double(hour), contact);
        //quotation = new Quotation(name, amount, delivery);
        dao.update(quotation);
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
}
