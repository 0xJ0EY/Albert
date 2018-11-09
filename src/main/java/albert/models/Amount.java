package albert.models;

/**
 * The Class Model Amount.
 *
 */
public class Amount {
    
    /** The price. */
    private double price;
    
    /** The hours. */
    private double hours;
    
    /** The Bcost. */
    private double Bcost;
    
    /** The contact. */
    private Contact contact;
    
    /** The id. */
    private int id;

    /**
     * Instantiates a new amount.
     */
    public Amount() {

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
     * Instantiates a new amount.
     *
     * @param price the price
     * @param hours the hours
     * @param contact the contact
     */
    public Amount(double price, double hours, Contact contact) {
        this.price = price;
        this.hours = hours;
        this.contact = contact;
    }

    /**
     * Gets the bcost.
     *
     * @return the bcost
     */
    public double getBcost() { return this.Bcost; }

    /**
     * Sets the bcost.
     *
     * @param Bcost the new bcost
     */
    public void setBcost(Double Bcost) { this.Bcost = Bcost; }

    /**
     * Gets the contact.
     *
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the contact.
     *
     * @param contact the new contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the hours.
     *
     * @return the hours
     */
    public double getHours() { return this.hours; }

    /**
     * Sets the hours.
     *
     * @param hours the new hours
     */
    public void setHours(double hours) { this.hours = hours; }

    /**
     * Sets the bcost.
     *
     * @param bcost the new bcost
     */
    public void setBcost(double bcost) {
        Bcost = bcost;
    }
}
