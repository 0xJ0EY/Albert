package albert.models;

public class Amount {
    private double price;
    private double hours;
    private int contact;
    private int id;

    public Amount(Double price, Double hours, String contact) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Amount(double price, double hours, int contact) {
        this.price = price;
        this.hours = hours;
        this.contact = contact;
    }


    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHours() { return this.hours; }

    public void setHours(double hours) { this.hours = hours; }



}
