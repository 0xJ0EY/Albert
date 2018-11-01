package albert.models;

import java.util.Date;

public class Expense {

    private int id;
    private double price;
    private String description;
    private Date created_at;
    private String name;

    public Expense(double price, String description, Date created_at,String name) {
        this.price = price;
        this.description = description;
        this.created_at = created_at;
        this.name=name;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() { return this.id; }

    public Date getCreated_at() { return this.created_at; }

    public void setName(String name) {
        this.name = name;
    }

    public String  getName() { return this.name; }

}
