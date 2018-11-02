package albert.models;

public class ContactEmail {

    private String emailAddress;

    private int contact;

    private int id;


    public ContactEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ContactEmail(String emailAddress, int contact) {
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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
