package albert.models;

import albert.services.PdfService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quotation {

    private int id;
    private String name;
    private Amount amount;
    private String product;
    private String description;
    private Timestamp created_at;
    private Project project;
    private int expectedHours;

    public int getExpectedHours() { return expectedHours; }

    public void setExpectedHours(int expectedHours) { this.expectedHours = expectedHours; }

    /**
     *
     * @param name
     */
    public Quotation(String name, Amount amount, String product) {
        this.name = name;
        this.amount = amount;
        this.product = product;
    }
    public Quotation(String name, String product, String description, Timestamp created_at) {
        this.name = name;
        this.product = product;
        this.description = description;
        this.created_at = created_at;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() { return amount; }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getProduct() { return this.product; }

    public void setDelivery(String product) { this.product = product; }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void generatePdf() throws ParseException {
        try {
            PdfService.getInstance().generateQuotationPdf(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }
}