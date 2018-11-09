package albert.models;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactPhoneNumber.
 * @author
 */
public class ContactPhoneNumber {

    /** The phone number. */
    private String phoneNumber;
    
    /** The contact. */
    private Contact contact;
    
    /** The id. */
    private int id;


    /**
     * Instantiates a new contact phone number.
     */
    public ContactPhoneNumber() {
    }

    /**
     * Instantiates a new contact phone number.
     *
     * @param phoneNumber the phone number
     */
    public ContactPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
