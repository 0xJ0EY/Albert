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

    private List<Expense> expenseList;

    private Contact contact;

    private String status = paidState.notPaid.toString();

    public Project(String name, String status) {
        this.name = name; this.status = status;
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

    public String isDone() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }

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
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}