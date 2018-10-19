package albert.services.pdfGenerator.generators;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.w3c.tidy.Tidy;

import java.io.*;

import static org.thymeleaf.templatemode.TemplateMode.HTML;

abstract public class Pdf {
    private static final String UTF_8 = "UTF-8";
    private Stage stage;


    protected String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setInputEncoding(UTF_8);
        tidy.setOutputEncoding(UTF_8);
        tidy.setXHTML(true);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(html.getBytes(UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        tidy.parseDOM(inputStream, outputStream);
        return outputStream.toString(UTF_8);
    }

    protected TemplateEngine templateResolver(String path) {
        // We set-up a Thymeleaf rendering engine. All Thymeleaf templates
        // are HTML-based files located under "src/test/resources". Beside
        // of the main HTML file, we also have partials like a footer or
        // a header. We can re-use those partials in different documents.
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix(path);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(HTML);
        templateResolver.setCharacterEncoding(UTF_8);


        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    protected String getFilePath(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save pdf");
        File file = fileChooser.showSaveDialog(stage);
        return file.getAbsolutePath();
    }
}
