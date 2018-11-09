package albert.services;

import albert.dao.ContactDAO;
import albert.dao.ProjectDAO;
import albert.models.*;
import com.itextpdf.text.DocumentException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.FileSystems;

import static org.thymeleaf.templatemode.TemplateMode.HTML;


// TODO: Auto-generated Javadoc
/**
 * The Class PdfService.
 * @author
 */
public class PdfService {

    /** The Constant UTF_8. */
    private static final String UTF_8 = "UTF-8";
    
    /** The stage. */
    private Stage stage;
    
    /** The instance. */
    private static PdfService instance;
    
    /** The resources. */
    private String resources;
    
    /** The template path. */
    private String template_path;
    
    /** The output. */
    private String output;
    
    /** The project DAO. */
    private ProjectDAO projectDAO = new ProjectDAO();
    
    /** The contact DAO. */
    private ContactDAO contactDAO = new ContactDAO();

    /**
     * Gets the single instance of PdfService.
     *
     * @return single instance of PdfService
     */
    public static PdfService getInstance() {
        if (instance == null)
            instance = new PdfService();

        return instance;
    }

    /**
     * Pdf will be generated in the folder resources.
     *
     * @param invoice the invoice
     * @return true, if successful
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws DocumentException the document exception
     */
    public boolean generateInvoicePdf(Invoice invoice) throws IOException, DocumentException {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/invoice/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        Project project = projectDAO.loadById(invoice.getProject().getId());
        Contact contact = contactDAO.loadById(project.getContact().getId());
        context.setVariable("contact", contact);
        context.setVariable("data", invoice);



        String renderedHtmlContent = templateEngine.process("templateInvoice", context);
        String xHtml = convertToXhtml(renderedHtmlContent);

        ITextRenderer renderer = new ITextRenderer();

        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "main", "resources","/")
                .toUri()
                .toURL()
                .toString();
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("PDF Bestand (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName("NieuweFactuur");
        fileChooser.setTitle("Factuur Exporteren");
        File file = fileChooser.showSaveDialog(stage);

        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        renderer.createPDF(outputStream);
        outputStream.close();
        return true;

    }

    /**
     * Pdf will be generated in the folder resources.
     *
     * @param quotation the quotation
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws DocumentException the document exception
     */
    public void generateQuotationPdf(Quotation quotation) throws IOException, DocumentException {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/invoice/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        int contact = quotation.getProject().getContact().getId();
        Project project = projectDAO.loadById(quotation.getProject().getId());
        Contact contactQ = contactDAO.loadById(project.getContact().getId());
        context.setVariable("contact", contactQ);
        context.setVariable("data", quotation);


        String renderedHtmlContent = templateEngine.process("templateQuotation", context);
        String xHtml = convertToXhtml(renderedHtmlContent);

        ITextRenderer renderer = new ITextRenderer();

        String baseUrl = FileSystems
                .getDefault()
                .getPath("src", "main", "resources","/")
                .toUri()
                .toURL()
                .toString();
        renderer.setDocumentFromString(xHtml, baseUrl);
        renderer.layout();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Offerte exporteren");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("PDF Bestand (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(stage);

        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        renderer.createPDF(outputStream);
        outputStream.close();
    }

    /**
     * Generate repports.
     *
     * @param rapportage the rapportage
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws DocumentException the document exception
     */
    public void generateRepports(Rapportage rapportage) throws IOException, DocumentException {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/rapportage/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("data", rapportage);


        String renderedHtmlContent = templateEngine.process("templateRapportage", context);
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

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save Pdf");
        File file = fileChooser.showSaveDialog(stage);

        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());

        renderer.createPDF(outputStream);
        outputStream.close();
    }

    /**
     * Sets the parms.
     */
    private void setParms(){

    }
    
    /**
     * Convert to xhtml.
     *
     * @param html the html
     * @return the string
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
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