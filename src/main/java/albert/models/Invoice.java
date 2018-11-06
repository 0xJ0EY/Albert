package albert.models;

import albert.services.PdfService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;

public class Invoice {

    private int id;
    private Amount amount;
    private String paid;
    private String dateNow;
    private Timestamp created_at;
    private Timestamp deliveryDate;
    private Project project;
    private Tax tax;
    DecimalFormat df=new DecimalFormat("0.00");

    public Invoice(String paid, Timestamp deliveryDate) {
        this.amount = amount;
    }
    public Invoice(){};

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }


    public String getPaid() { return this.paid; }

    public void setPaid(String paid) { this.paid = paid; }

    public Timestamp getCreated_at() { return  this.created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getDeliveryDate() { return deliveryDate; }

    public void setDeliveryDate(Timestamp deliveryDate) { this.deliveryDate = deliveryDate; }


    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;

    }
    public double getAmountHours() { return amount.getHours(); }

    public double getAmountPrice() { return amount.getPrice(); }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }

    public void generatePdf() {

    }

    public double calculateTax() {
        double taxPart = this.getAmount().getPrice() * (new Double(this.getTax().getPercentage()) / 100);
        taxPart = Math.round(taxPart * 100.00) / 100.00;
        return taxPart;
    }

}