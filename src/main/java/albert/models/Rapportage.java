package albert.models;

import albert.services.PdfService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Rapportage {

    private String name;
    private int id;
    private Timestamp startDate;
    private Timestamp endDate;
    private Invoice invoice;
    private ArrayList<Expense> expenseArrayList;

    public void generatePdf(){


        try {
            PdfService.getInstance().generateRepports(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public ArrayList<Expense> getExpenseArrayList() {
        return expenseArrayList;
    }

    public void setExpenseArrayList(ArrayList<Expense> expenseArrayList) {
        this.expenseArrayList = expenseArrayList;
    }


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
