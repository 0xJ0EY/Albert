package albert.models;


import java.sql.Timestamp;

/**
 * The Class Model Project.
 *
 */
public class Project {

    /** The id. */
    private int id;

    /** The name. */
    private String name = "";
    
    /** The created at. */
    private Timestamp created_at;
    
    /** The done. */
    private Boolean done;
    
    /** The contact. */
    private Contact contact;
    
    /** The description. */
    private String description = "";

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() { return this.id; }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
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
     * Gets the created at.
     *
     * @return the created at
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * Sets the created at.
     *
     * @param created_at the new created at
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Gets the done.
     *
     * @return the done
     */
    public Boolean getDone() {
        return done;
    }

    /**
     * Sets the done.
     *
     * @param done the new done
     */
    public void setDone(Boolean done) {
        this.done = done;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}