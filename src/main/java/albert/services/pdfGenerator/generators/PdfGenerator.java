package albert.services.pdfGenerator.generators;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface PdfGenerator{

    public void generatePdf(Object invoice) throws IOException, DocumentException;

}
