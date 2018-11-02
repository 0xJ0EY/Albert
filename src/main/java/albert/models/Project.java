package albert.models;


import java.sql.Timestamp;

/**
 *
 */
public class Project {

    private int id;

    private String name;
    private String status = PaidState.notPaid.toString();
    private Timestamp created_at;
    private Boolean done;
    private Contact contact;

    public Project() {

    }

    public Contact getContact() { return contact; }

    public void setContact(Contact contact) { this.contact = contact; }

    public Project(String name, String status) {
        this.name = name; this.status = status;
    }



    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String isDone() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }



    public void setName(String name) {
            this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public String getStatus() {
        return status;
    }

    public int getId() {
        return this.id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}