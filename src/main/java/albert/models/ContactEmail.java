package albert.models;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactEmail.
 * @author
 */
public class ContactEmail {

    /** The email address. */
    private String emailAddress;
    
    /** The contact. */
    private Contact contact;
    
    /** The id. */
    private int id;

    /**
     * Instantiates a new contact email.
     */
    public ContactEmail() {
    }

    /**
     * Instantiates a new contact email.
     *
     * @param emailAddress the email address
     */
    public ContactEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address.
     *
     * @param emailAddress the new email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the contact.
     *
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the contact.
     *
     * @param contact the new contact
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
