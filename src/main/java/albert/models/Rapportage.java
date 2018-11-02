package albert.models;

import java.sql.Timestamp;
import java.util.Date;

public class Rapportage {

    private String name;
    private int id;
    private Timestamp startDate;
    private Timestamp endDate;
    private Invoice invoice;

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    private Expense expense;

    public void setName(String name) { this.name = name;   }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Timestamp getStartDate() { return startDate; }

    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }

    public Timestamp getEndDate() { return endDate; }

    public void setEndDate(Timestamp endDate) { this.endDate = endDate; }
}
