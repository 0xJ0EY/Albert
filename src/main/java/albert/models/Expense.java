package albert.models;

import java.util.Date;

public class Expense {

    private int id;
    private double price;
    private String description;
    private Date created_at;
    //TODO: make get en set

    public Expense(double price, String description) {
        this.price = price;
        this.description = description;
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
}
