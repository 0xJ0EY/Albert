package albert.models;

import java.sql.Timestamp;
import java.util.Date;

public class Expense {

    private int id;
    private double price;
    private String name;
    private String description;
    private Timestamp created_at;

    public Expense(double price, String description, Timestamp created_at, String name) {
        this.price = price;
        this.description = description;
        this.created_at = created_at;
        this.name=name;

    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



}
