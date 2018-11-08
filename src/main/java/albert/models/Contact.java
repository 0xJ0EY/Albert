package albert.models;


import java.sql.Timestamp;
import java.util.ArrayList;

public class Contact {

    private String name;

    private int id = 0;
    private String firstName;
    private String lastName;
    private String company;
    private String telephoneNumber;
    private String postalCode;
    private ArrayList<ContactEmail> emails = new ArrayList<>();
    private ArrayList<ContactPhoneNumber> phoneNumbers = new ArrayList<>();
    private String website;
    private String description;
    private String streetName;
    private String houseNumber;
    private String city;
    private Timestamp created_at;

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    private ArrayList<Project> project;

    public ArrayList<ContactEmail> getEmails() {
        return this.emails;
    }

    public ArrayList<ContactPhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setEmails(ArrayList<ContactEmail> email) {
        this.emails = email;
    }

    public void addEmail(ContactEmail email) {
        email.setContact(this);
        this.emails.add(email);
    }

    public void removeEmail(ContactEmail email) {
        this.emails.remove(email);
    }

    public void setPhoneNumbers(ArrayList<ContactPhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumber(ContactPhoneNumber phoneNumber) {
        phoneNumber.setContact(this);
        this.phoneNumbers.add(phoneNumber);
    }

    public void removePhoneNumber(ContactPhoneNumber phoneNumber) {
        this.phoneNumbers.remove(phoneNumber);
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postal_code) {
        this.postalCode = postal_code;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) { this.name = name; }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Project> getProject() {
        return project;
    }

    public void setProject(ArrayList<Project> project) {
        this.project = project;
    }

    public String toFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}