package albert.models;

// TODO: Auto-generated Javadoc
/**
 * The Class Tax.
 * @author
 */
public class Tax {

    /** The id. */
    private int id;
    
    /** The percentage. */
    private int percentage;
    
    /** The name. */
    private String name;
    
    /** The tax part. */
    private double taxPart;

    /**
     * Instantiates a new tax.
     *
     * @param name the name
     * @param percentage the percentage
     */
    public Tax(String name, int percentage) {
        this.name = name;
        this.percentage = percentage; }

    /**
     * Instantiates a new tax.
     */
    public Tax() {

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
     * Sets the percentage.
     *
     * @param percentage the new percentage
     */
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() { return this.name; }

    /**
     * Gets the percentage.
     *
     * @return the percentage
     */
    public int getPercentage() { return this.percentage; }

    /**
     * Gets the tax part.
     *
     * @return the tax part
     */
    public Double getTaxPart() { return this.taxPart; }

    /**
     * Sets the tax part.
     *
     * @param taxPart the new tax part
     */
    public void setTaxPart(double taxPart) { this.taxPart = taxPart; }

}
