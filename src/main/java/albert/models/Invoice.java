package albert.models;

import java.sql.Timestamp;
import java.util.Date;

public class Invoice {


    private int id;
    private Amount amount;
    private String paid;
    private Timestamp created_at;
    private Timestamp deliveryDate;
    private int project;
    private Tax tax;

    public Invoice(String paid, Timestamp deliveryDate) {
        this.amount = amount;
    }
    public Invoice(){};

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }


    public String getPaid() { return this.paid; }

    public void setPaid(String paid) { this.paid = paid; }

    public Date getCreated_at() { return  this.created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getDeliveryDate() { return deliveryDate; }

    public void setDeliveryDate(Timestamp deliveryDate) { this.deliveryDate = deliveryDate; }


    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

}