package albert.services.pdfGenerator.generators;

import albert.services.Data;
import com.itextpdf.text.DocumentException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.FileSystems;


public class PdfInvoice extends Pdf  implements PdfGenerator{

    private static PdfInvoice instance;
    private static final String templateName = "templateFactuur";
    private Data data = new Data();
    private static final String UTF_8 = "UTF-8";

    @Override
public void generatePdf(Object invoice) throws IOException, DocumentException {

    Context context = new Context();
    context.setVariable("data", invoice);

    TemplateEngine templateEngine = this.templateResolver("/templates/invoice/");
    // Flying Saucer needs XHTML - not just normal HTML. To make our life
    // easy, we use JTidy to convert the rendered Thymeleaf template to
    // XHTML. Note that this might no work for very complicated HTML. But
    // it's good enough for a simple letter.
    String renderedHtmlContent = templateEngine.process("templateFactuur", context);
    String xHtml = null;
    try {
        xHtml = this.convertToXhtml(renderedHtmlContent);
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

    ITextRenderer renderer = new ITextRenderer();

    String baseUrl = null;

        baseUrl = FileSystems.getDefault().getPath("resources").toUri().toURL().toString();

    renderer.setDocumentFromString(xHtml, baseUrl);
    renderer.layout();
    // And finally, we create the PDF:
    OutputStream outputStream = null;

        outputStream = new FileOutputStream(this.getFilePath());

        renderer.createPDF(outputStream);

        outputStream.close();

}


}
