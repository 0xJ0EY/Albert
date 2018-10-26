package albert.models;

import java.util.ArrayList;

public class Invoice {

    private int id;
    private String name;
    private ArrayList<Amount> amountList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Amount> getAmountList() {
        return amountList;
    }

    public void setAmountList(ArrayList<Amount> amountList) {
        this.amountList = amountList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ArrayList<Amount> getBedragen() {
        return bedragen;
    }

    public void setBedragen(ArrayList<Amount> bedragen) {
        this.bedragen = bedragen;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Contact contact;
    private ArrayList<Amount> bedragen;

    /**
     *
     * @param id
     * @param name
     */
    /*public invoice(int id, String name, ArrayList<Amount> amountArrayList) {
        this.id = id;
        this.name = name;


    }*/
}