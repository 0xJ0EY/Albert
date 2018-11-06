package albert.models;


import java.sql.Timestamp;

/**
 *
 */
public class Project {

    private int id;

    private String name;
    private PaidState status = PaidState.NOT_PAID;
    private Timestamp created_at;
    private Boolean done;
    private Tax tax;
    private Contact contact;

    public Project() {

    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaidState getStatus() {
        return status;
    }

    public void setStatus(PaidState status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

}