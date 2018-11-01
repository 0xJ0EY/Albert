package albert.models;

public class Amount {
    private int id;
    private double price;
    private double hours;
    private String contact;

    public Amount(double price, double hours, String contact, int id) {
        this.price = price;
        this.hours = hours;
        this.contact = contact;
        this.id =id;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHours() { return this.hours; }

    public void setHours(int hours) { this.hours = hours; }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }



}
