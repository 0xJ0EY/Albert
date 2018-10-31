package albert.models;

public class Quotation {

    private int id;
    private String name;
    private Amount amount;
    private String delivery;
    private String description;

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

    public String getDelivery() { return this.delivery; }

    public void setDelivery(String delivery) { this.delivery = delivery; }

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

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Contact contact;
    private Amount bedragen;

    /**
     *
     * @param name
     */
    public Quotation(String name, Amount amount, String delivery) {
        this.name = name;
        this.amount = amount;
        this.delivery = delivery;
    }
}