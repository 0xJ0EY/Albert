package albert.models;

public class Amount {
    private int id;
    private double price;
    private double hours;
    private Contact contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Amount(double price, double hours, String contact) {
        this.price = price;
        this.hours = hours;

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
