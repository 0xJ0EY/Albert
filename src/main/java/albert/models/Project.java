package albert.models;


import java.sql.Timestamp;

/**
 *
 */
public class Project {

    private int id;
<<<<<<< HEAD

    private String name = "";
    private Timestamp created_at;
    private Boolean done;
    private Contact contact;
    private String description = "";
=======
    private String name;
    private String status = PaidState.NOT_PAID.toString();
    private Timestamp created_at;
    private Boolean done;
    private int contactId;
    private int invoiceId;
    private int expenseId;
    private int quotationId;
    private Tax tax;

    public Project() {

    }

>>>>>>> 61b813c387df377ddbf742c6480a45401a6b655a

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getContactId() { return contactId; }

    public void setContactId(int contactId) { this.contactId = contactId; }

    public Project(String name, String status) {
        this.name = name; this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() { return this.id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

>>>>>>> 61b813c387df377ddbf742c6480a45401a6b655a
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}