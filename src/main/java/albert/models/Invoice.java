package albert.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {

    private int id;
    private String name;
    private Amount amount;
    private String delivery;
    private String paid;
    private Date created_at;
    private Date deliveryDate;
    private String dateNow;
    private Project project;
    private Tax tax;

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public String getPaid() { return this.paid; }

    public void setPaid(String paid) { this.paid = paid; }

    public Date getCreated_at() { return  this.created_at; }

    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getDeliveryDate() { return deliveryDate; }

    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelivery() { return  this.delivery; }

    public void setDelivery(String delivery) { this.delivery = delivery; }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

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
    public Invoice(String name, Amount amount, String delivery) {
        this.name = name;
        this.amount = amount;
        this.delivery = delivery;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;

    }
    public double getAmountHours() { return amount.getHours(); }

    public double getAmountPrice() { return amount.getPrice(); }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }
}