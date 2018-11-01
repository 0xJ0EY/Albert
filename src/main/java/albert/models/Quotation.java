package albert.models;

import java.util.Date;

public class Quotation {

    private int id;
    private String name;
    private Amount amount;
    private String product;
    private String description;
    private Date created_at;

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Amount getBedragen() {
        return bedragen;
    }

    public void setBedragen(Amount bedragen) {
        this.bedragen = bedragen;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    private Contact contact;
    private Amount bedragen;

    /**
     *
     * @param name
     */
    public Quotation(String name, Amount amount, String product) {
        this.name = name;
        this.amount = amount;
        this.product = product;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Project getProject() {
        return null;
    }
}