package albert.models;

public class Amount {
    private double price;
    private double hours;
    private Contact contact

    public Amount(double price, double hours, Contact contact) {
        this.price = price;
        this.hours = hours;
        this.contact = contact;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public double getPrice() {
        return price;
    }

    public void setPRice(double price) {
        this.price = price;
    }



}
