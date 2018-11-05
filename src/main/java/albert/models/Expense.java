package albert.models;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;

public class Expense {

    private int id;
    private double price;
    private String name;
    private String description;
    private Timestamp created_at;
    private double btw = 1.21;

    public Expense(int id, double price, String description, Timestamp created_at, String name) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.created_at = created_at;
        this.name=name;

    }

    public Expense(){

    }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

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
        DecimalFormat decim = new DecimalFormat("####.##");
        Double price2 = Double.parseDouble(decim.format(price));
        this.price = price2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() { return this.id; }

    public Timestamp getCreated_at() { return this.created_at; }

    public double getBtw() { return btw; }

    public void setBtw(double btw) { this.btw = btw; }



}
