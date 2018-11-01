package albert.models;

public class ContactEmail {

    private String emailAddress;

    private Contact contact;

    private int id;


    public ContactEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ContactEmail(String emailAddress, Contact contact) {
        this.emailAddress = emailAddress;
        this.contact = contact;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}