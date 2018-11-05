package albert.models;

public class Amount {
    private double price;
    private double hours;
    private double Bcost;
    private Contact contact;
    private int id;

    public Amount(Double price, Double hours) {
        this.price = price;
        this.hours = hours;
    }

    public Amount() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Amount(double price, double hours, Contact contact) {
        this.price = price;
        this.hours = hours;
        this.contact = contact;
    }

    public double getBcost() { return this.Bcost; }

    public void setBcost(Double Bcost) { this.Bcost = Bcost; }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
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

    public void setBcost(double bcost) {
        Bcost = bcost;
    }
}
