package albert.models;

import albert.services.PdfService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * The Class Model Rapportage.
 *
 */
public class Rapportage {

    /** The name. */
    private String name;
    
    /** The id. */
    private int id;
    
    /** The start date. */
    private Timestamp startDate;
    
    /** The end date. */
    private Timestamp endDate;
    
    /** The invoice. */
    private Invoice invoice;
    
    /** The expense array list. */
    private ArrayList<Expense> expenseArrayList;

    /**
     * Generate pdf.
     */
    public void generatePdf(){


        try {
            PdfService.getInstance().generateRepports(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the invoice.
     *
     * @return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Sets the invoice.
     *
     * @param invoice the new invoice
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Gets the expense array list.
     *
     * @return the expense array list
     */
    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }

    /**
     * Sets the expense array list.
     *
     * @param expenseArrayList the new expense array list
     */
    public void setExpenseArrayList(ArrayList<Expense> expenseArrayList) {
        this.expenseArrayList = expenseArrayList;
    }


    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) { this.name = name;   }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Timestamp getStartDate() { return startDate; }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Timestamp getEndDate() { return endDate; }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Timestamp endDate) { this.endDate = endDate; }
}
