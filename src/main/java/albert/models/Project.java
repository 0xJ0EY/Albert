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
    private int contactId;
    private int invoiceId;
    private int expenseId;
    private int quotationId;

    public Project() {

    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

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