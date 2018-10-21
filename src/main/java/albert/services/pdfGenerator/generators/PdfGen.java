package albert.services.pdfGenerator.generators;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface PdfGen {

    public void generatePdf(Object obj) throws IOException, DocumentException;

}
