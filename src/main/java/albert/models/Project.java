package albert.models;


import java.sql.Timestamp;

/**
 *
 */
public class Project {

    private int id;

    private int invoice;
    private int contact;
    private int expense;
    private int quotation;
    private String name;
    private String status = PaidState.notPaid.toString();
    private Timestamp created_at;
    private Boolean done;


    public Project(String name, String status) {
        this.name = name; this.status = status;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getQuotation() {
        return quotation;
    }

    public void setQuotation(int quotation) {
        this.quotation = quotation;
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