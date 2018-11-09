package albert.models;

import albert.services.PdfService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The Class Model Invoice.
 *
 */
public class Invoice {

    /** The id. */
    private int id;
    
    /** The amount. */
    private Amount amount;
    
    /** The paid. */
    private Boolean paid;
    
    /** The date now. */
    private String dateNow;
    
    /** The created at. */
    private Timestamp created_at;
    
    /** The delivery date. */
    private Timestamp deliveryDate;
    
    /** The project. */
    private Project project;
    
    /** The tax. */
    private Tax tax;
    
    /** The description. */
    private String description;
    
    /** The df. */
    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Instantiates a new invoice.
     *
     * @param paid the paid
     * @param deliveryDate the delivery date
     */
    public Invoice(String paid, Timestamp deliveryDate) {
        this.amount = amount;
    }
    
    /**
     * Instantiates a new invoice.
     */
    public Invoice(){};

    /**
     * Gets the tax.
     *
     * @return the tax
     */
    public Tax getTax() {
        return tax;
    }

    /**
     * Sets the tax.
     *
     * @param tax the new tax
     */
    public void setTax(Tax tax) {
        this.tax = tax;
    }


    /**
     * Gets the paid.
     *
     * @return the paid
     */
    public Boolean getPaid() { return this.paid; }

    /**
     * Sets the paid.
     *
     * @param paid the new paid
     */
    public void setPaid(Boolean paid) { this.paid = paid; }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public Timestamp getCreated_at() { return  this.created_at; }

    /**
     * Sets the created at.
     *
     * @param created_at the new created at
     */
    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    /**
     * Gets the delivery date.
     *
     * @return the delivery date
     */
    public Timestamp getDeliveryDate() { return deliveryDate; }

    /**
     * Sets the delivery date.
     *
     * @param deliveryDate the new delivery date
     */
    public void setDeliveryDate(Timestamp deliveryDate) { this.deliveryDate = deliveryDate; }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(Amount amount) {
        this.amount = amount;
    }


    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {

        return id;
    }

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
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() { return description; }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) { this.description = description; }

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

    /**
     * Generate pdf.
     *
     * @throws ParseException the parse exception
     */
    public void generatePdf() throws ParseException {
        this.getTax().setTaxPart(this.calculateTax());
        String value = df.format(this.getTax().getTaxPart() + this.getAmount().getPrice());
        this.getAmount().setBcost(df.parse(value).doubleValue());

        try {
            PdfService.getInstance().generateInvoicePdf(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculate tax.
     *
     * @return the double
     */
    public double calculateTax() {
        double taxPart = this.getAmount().getPrice() * (new Double(this.getTax().getPercentage()) / 100);
        taxPart = Math.round(taxPart * 100.00) / 100.00;
        return taxPart;
    }

}