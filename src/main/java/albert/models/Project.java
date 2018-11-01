package albert.models;



import java.util.List;

/**
 *
 */
public class Project {

    private int id;
    private String name;

    private List<Invoice> invoiceList;

    private List<Quotation> quotationList;

    private Contact contact;

    private boolean done = false;

    private List<Expense> expenseList;



    public Project(String name) {
        this.name = name;
    }

    public void setQuotationList(List<Quotation> quotationList) { this.quotationList = quotationList; }

    public List<Quotation> getQuotationList() { return quotationList; }

    public void setId(int id) {
        this.id = id;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContactList(Contact contact) {
        this.contact = contact;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String getName() {
        return null;
    }

    public int getId() {
        return 0;
    }
}