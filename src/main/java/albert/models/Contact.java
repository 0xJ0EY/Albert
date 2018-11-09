package albert.models;


import java.sql.Timestamp;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Contact.
 * @author
 */
public class Contact {

    /** The name. */
    private String name;

    /** The id. */
    private int id = 0;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The company. */
    private String company;
    
    /** The telephone number. */
    private String telephoneNumber;
    
    /** The postal code. */
    private String postalCode;
    
    /** The emails. */
    private ArrayList<ContactEmail> emails = new ArrayList<>();
    
    /** The phone numbers. */
    private ArrayList<ContactPhoneNumber> phoneNumbers = new ArrayList<>();
    
    /** The website. */
    private String website;
    
    /** The description. */
    private String description;
    
    /** The street name. */
    private String streetName;
    
    /** The house number. */
    private String houseNumber;
    
    /** The city. */
    private String city;
    
    /** The created at. */
    private Timestamp created_at;

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

    /** The project. */
    private ArrayList<Project> project;

    /**
     * Gets the emails.
     *
     * @return the emails
     */
    public ArrayList<ContactEmail> getEmails() {
        return this.emails;
    }

    /**
     * Gets the phone numbers.
     *
     * @return the phone numbers
     */
    public ArrayList<ContactPhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets the emails.
     *
     * @param email the new emails
     */
    public void setEmails(ArrayList<ContactEmail> email) {
        this.emails = email;
    }

    /**
     * Adds the email.
     *
     * @param email the email
     */
    public void addEmail(ContactEmail email) {
        email.setContact(this);
        this.emails.add(email);
    }

    /**
     * Removes the email.
     *
     * @param email the email
     */
    public void removeEmail(ContactEmail email) {
        this.emails.remove(email);
    }

    /**
     * Sets the phone numbers.
     *
     * @param phoneNumbers the new phone numbers
     */
    public void setPhoneNumbers(ArrayList<ContactPhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * Adds the phone number.
     *
     * @param phoneNumber the phone number
     */
    public void addPhoneNumber(ContactPhoneNumber phoneNumber) {
        phoneNumber.setContact(this);
        this.phoneNumbers.add(phoneNumber);
    }

    /**
     * Removes the phone number.
     *
     * @param phoneNumber the phone number
     */
    public void removePhoneNumber(ContactPhoneNumber phoneNumber) {
        this.phoneNumbers.remove(phoneNumber);
    }

    /**
     * Gets the house number.
     *
     * @return the house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the house number.
     *
     * @param houseNumber the new house number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
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
     * Gets the company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company.
     *
     * @param company the new company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the telephone number.
     *
     * @return the telephone number
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the telephone number.
     *
     * @param telephoneNumber the new telephone number
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Gets the postal code.
     *
     * @return the postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param postal_code the new postal code
     */
    public void setPostalCode(String postal_code) {
        this.postalCode = postal_code;
    }


    /**
     * Gets the website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets the website.
     *
     * @param website the new website
     */
    public void setWebsite(String website) {
        this.website = website;
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

    /**
     * Gets the street name.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name.
     *
     * @param streetName the new street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the project.
     *
     * @return the project
     */
    public ArrayList<Project> getProject() {
        return project;
    }

    /**
     * Sets the project.
     *
     * @param project the new project
     */
    public void setProject(ArrayList<Project> project) {
        this.project = project;
    }

    /**
     * To full name.
     *
     * @return the string
     */
    public String toFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}