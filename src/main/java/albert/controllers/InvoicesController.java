package albert.controllers;

import albert.models.Invoice;
import albert.services.pdfGenerator.generators.PdfGen;
import albert.services.pdfGenerator.generators.PdfInvoice;
import com.itextpdf.text.DocumentException;
import router.Request;
import router.pages.DetailPage;
import router.pages.OverviewPage;
import router.response.Response;
import router.response.ViewResponse;
import router.templates.TemplateController;
import router.views.PageView;

import javax.xml.soap.Detail;
import java.io.IOException;

public class InvoicesController extends PageController implements OverviewPage, DetailPage {
    private Invoice invoice;
    private PdfInvoice gen;
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

    public void generatePdf(Invoice invoice) throws IOException, DocumentException {
        gen.generatePdf(invoice);
    }
}
