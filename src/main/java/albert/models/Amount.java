package albert.models;

public class Amount {
    private double price;
    private double hours;
    private String contact;

    public Amount(double price, double hours, String contact) {
        this.price = price;
        this.hours = hours;
        this.contact = contact;
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

    public void setHours(double hours) { this.hours = hours; }



}
