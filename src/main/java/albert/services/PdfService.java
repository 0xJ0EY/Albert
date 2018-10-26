package albert.services;

import albert.models.Invoice;
import com.itextpdf.text.DocumentException;
import javafx.stage.Stage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.FileSystems;

import static org.thymeleaf.templatemode.TemplateMode.HTML;


public class PdfService {

    private static final String UTF_8 = "UTF-8";
    private Stage stage;
    private static PdfService instance;
    private String resources;
    private String template_path;
    private String output;

    public static PdfService getInstance() {
        if (instance == null)
            instance = new PdfService();

        return instance;
    }

    /**
     * Pdf will be generated in the folder resources
     * @param invoice
     * @throws IOException
     * @throws DocumentException
     */
    public boolean generateInvoicePdf(Invoice invoice) throws IOException, DocumentException {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/Invoice/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);


        Context context = new Context();
        context.setVariable("data", invoice);


        String renderedHtmlContent = templateEngine.process("templateFactuur", context);
        String xHtml = convertToXhtml(renderedHtmlContent);

        ITextRenderer renderer = new ITextRenderer();

        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "main", "resources", "/")
                .toUri()
                .toURL()
                .toString();
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();

        OutputStream outputStream = new FileOutputStream("src/main/resources/invoice.pdf");
        renderer.createPDF(outputStream);
        outputStream.close();
        return true;

    }
    private boolean generateRepports(){

    }
    private String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }


}