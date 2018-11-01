package albert.models;


import java.util.ArrayList;
import java.util.Date;

public class Contact {

    private String name;

    private int id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String postcode;

    private ArrayList<ContactEmail> email;

    private String website;

    private String beschrijving;

    private String straatnaam;

    private String houseNumber;

    private String woonplaats;

    private Date created_at;

    public java.sql.Date getCreated_at() {
        return (java.sql.Date) created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    private Project project;

    public ArrayList<ContactEmail> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<ContactEmail> email) {
        this.email = email;
    }


    private String company;
    /**
     *
     * @param firstName
     * @param lastName
     */
    public Contact(String firstName, String lastName){
        this.firstName= firstName;
        this.lastName = lastName;
    }

    //invoice constructor
    public Contact(String company, String firstName, String lastName, String straatnaam, String houseNumber, String postcode, String woonplaats) {
        this.company = company;
        this.firstName= firstName;
        this.lastName = lastName;
        this.straatnaam = straatnaam;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param housenumber
     * @param telephoneNumber
     * @param postcode
     * @param email
     * @param website
     * @param beschrijving
     * @param straatnaam
     * @param woonplaats
     */
    public Contact(String firstName, String lastName, String housenumber, String telephoneNumber, String postcode,ArrayList<String> email, String website, String beschrijving, String straatnaam, String woonplaats) {
        this.name = firstName + " " +lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.postcode = postcode;
        //TODO fix email connection wiith contactemail
        this.website = website;
        this.beschrijving = beschrijving;
        this.straatnaam = straatnaam;
        this.houseNumber = housenumber;
        this.woonplaats = woonplaats;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setName(String name) { this.name = name; }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
