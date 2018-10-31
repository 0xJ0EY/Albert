package albert.models;


import java.util.ArrayList;

public class Contact {

    private String name;

    private int id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String postcode;

    private ArrayList<String> email;

    private String website;

    private String beschrijving;

    private String straatnaam;

    private String houseNumber;

    private String woonplaats;

    private String created_at;

    /**
     *
     * @param firstName
     * @param lastName
     */
    public Contact(String firstName, String lastName){
        this.firstName= firstName;
        this.lastName = lastName;
    }
//TODO added telephonenumber

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
    public Contact(String firstName, String lastName, String housenumber, String telephoneNumber, String postcode, ArrayList<String> email, String website, String beschrijving, String straatnaam, String woonplaats) {
        this.name = firstName + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.postcode = postcode;
        this.email = email;
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

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
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

}
