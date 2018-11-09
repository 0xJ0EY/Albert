package albert.models;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * The Class Model Expense.
 *
 */
public class Expense {

    /** The id. */
    private int id;
    
    /** The price. */
    private double price;
    
    /** The name. */
    private String name;
    
    /** The description. */
    private String description;
    
    /** The created at. */
    private Timestamp created_at;
    
    /** The btw. */
    private double btw = 1.21;
    
    /** The project. */
    private Project project;

    /**
     * Instantiates a new expense.
     *
     * @param id the id
     * @param price the price
     * @param description the description
     * @param created_at the created at
     * @param name the name
     */
    public Expense(int id, double price, String description, Timestamp created_at, String name) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.created_at = created_at;
        this.name=name;

    }

    /**
     * Instantiates a new expense.
     */
    public Expense(){

    }

    /**
     * Sets the created at.
     *
     * @param created_at the new created at
     */
    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
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
        DecimalFormat decim = new DecimalFormat("####.##");
        Double price2 = Double.parseDouble(decim.format(price));
        this.price = price2;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() { return this.id; }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    public Timestamp getCreated_at() { return this.created_at; }

    /**
     * Gets the btw.
     *
     * @return the btw
     */
    public double getBtw() { return btw; }

    /**
     * Sets the btw.
     *
     * @param btw the new btw
     */
    public void setBtw(double btw) { this.btw = btw; }

    /**
     * Gets the project.
     *
     * @return the project
     */
    public Project getProject() { return project; }

    /**
     * Sets the project.
     *
     * @param project the new project
     */
    public void setProject(Project project) { this.project = project; }
}
