package albert.models;


/**
 *
 */
public class Project {

    private int id;

    private String name;

    private Contact contact;

    private String status = PaidState.notPaid.toString();

    public void setId(int id) {
        this.id = id;
    }

    public Project(String name, String status) {
        this.name = name; this.status = status;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContactList(Contact contact) {
        this.contact = contact;
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

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return this.id;
    }
}