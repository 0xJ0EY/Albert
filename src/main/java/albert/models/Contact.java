package albert.models;


import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Contact {


    private int id;

    private String firstName;

    private String lastName;

    private int telephoneNumber;

    private String postcode;

    private ArrayList<ContactEmail> email;

    private String website;

    private String beschrijving;

    private String straatnaam;

    private String houseNumber;

    private String woonplaats;

    private Timestamp created_at;

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
    public Contact(String firstName, String lastName, String housenumber, String telephoneNumber, String postcode,ArrayList<ContactEmail>email, String website, String beschrijving, String straatnaam, String woonplaats, Timestamp created_at) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = Integer.valueOf(telephoneNumber);
        this.postcode = postcode;
        this.website = website;
        this.beschrijving = beschrijving;
        this.straatnaam = straatnaam;
        this.houseNumber = housenumber;
        this.woonplaats = woonplaats;
        this.created_at= created_at;
    }
    /**
     *
     * @param firstName
     * @param lastName
     */
    public Contact(String firstName, String lastName){
        this.firstName= firstName;
        this.lastName = lastName;
    }
    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    private ArrayList<Project> project;

    public ArrayList<ContactEmail> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<ContactEmail> email) {
        this.email = email;
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

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
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


    public int getId() {
        return this.id;
    }

    public ArrayList<Project> getProject() {
        return project;
    }

    public void setProject(ArrayList<Project> project) {
        this.project = project;
    }
}
