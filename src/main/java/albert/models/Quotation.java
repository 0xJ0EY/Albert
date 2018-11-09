package albert.models;

import albert.services.PdfService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Quotation.
 * @author
 */
public class Quotation {

    /** The id. */
    private int id;
    
    /** The name. */
    private String name;
    
    /** The amount. */
    private Amount amount;
    
    /** The product. */
    private String product;
    
    /** The description. */
    private String description;
    
    /** The created at. */
    private Timestamp created_at;
    
    /** The project. */
    private Project project;
    
    /** The expected hours. */
    private double expectedHours;
    
    /** The expected price. */
    private double expectedPrice;

    /**
     * Instantiates a new quotation.
     */
    public Quotation(){

    }

    /**
     * Gets the expected hours.
     *
     * @return the expected hours
     */
    public double getExpectedHours() { return expectedHours; }

    /**
     * Sets the expected hours.
     *
     * @param expectedHours the new expected hours
     */
    public void setExpectedHours(double expectedHours) { this.expectedHours = expectedHours; }

    /**
     * Instantiates a new quotation.
     *
     * @param name the name
     * @param amount the amount
     * @param product the product
     */
    public Quotation(String name, Amount amount, String product) {
        this.name = name;
        //this.amount = amount;
        this.product = product;
    }
    
    /**
     * Instantiates a new quotation.
     *
     * @param name the name
     * @param product the product
     * @param description the description
     * @param created_at the created at
     */
    public Quotation(String name, String product, String description, Timestamp created_at) {
        this.name = name;
        this.product = product;
        this.description = description;
        this.created_at = created_at;
    }
    
    /**
     * Sets the product.
     *
     * @param product the new product
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public Amount getAmount() { return amount; }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    /**
     * Gets the expected price.
     *
     * @return the expected price
     */
    public double getExpectedPrice() {
        return expectedPrice;
    }

    /**
     * Sets the expected price.
     *
     * @param expectedPrice the new expected price
     */
    public void setExpectedPrice(double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    /**
     * Gets the product.
     *
     * @return the product
     */
    public String getProduct() { return this.product; }

    /**
     * Sets the delivery.
     *
     * @param product the new delivery
     */
    public void setDelivery(String product) { this.product = product; }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() { return this.description; }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() { return id; }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the project.
     *
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the project.
     *
     * @param project the new project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * Sets the created at.
     *
     * @param created_at the new created at
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Generate pdf.
     *
     * @throws ParseException the parse exception
     */
    public void generatePdf() throws ParseException {
        try {
            PdfService.getInstance().generateQuotationPdf(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the current date.
     *
     * @return the current date
     */
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }
}