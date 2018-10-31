package albert.models;


public class Contact {

    private String name;

    private int id;

    private String firstName;

    private String lastName;

    private String addres;

    private String telephoneNumber;

    private String postcode;

    private String email;

    private String website;

    private String beschrijving;

    private String straatnaam;

    private String woonplaats;

    private String created_at;

    private String updated_at;



    private String houseNumber;

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
    public Contact(String firstName, String lastName, String housenumber, String telephoneNumber, String postcode, String email, String website, String beschrijving, String straatnaam, String woonplaats) {
        this.name = firstName + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addres = housenumber;
        this.telephoneNumber = telephoneNumber;
        this.postcode = postcode;
        this.email = email;
        this.website = website;
        this.beschrijving = beschrijving;
        this.straatnaam = straatnaam;
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

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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


    public void setName(String name) {

    }

    public String getName() {
        return null;
    }

    public int getId() {
        return 0;
    }

}
