package albert.models;


import java.sql.Timestamp;

/**
 *
 */
public class Project {

    private int id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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