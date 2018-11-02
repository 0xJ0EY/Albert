package albert.models;

import albert.services.PdfService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;

public class Invoice {

    private int id;
    private String name;
    private Amount amount;
    private String delivery;
    private String paid;
    private String dateNow;
    private Timestamp created_at;
    private Timestamp deliveryDate;
    private Project project;
    private Tax tax;
    DecimalFormat df=new DecimalFormat("0.00");

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }


    public String getPaid() { return this.paid; }

    public void setPaid(String paid) { this.paid = paid; }

    public Date getCreated_at() { return  this.created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getDeliveryDate() { return deliveryDate; }

    public void setDeliveryDate(Timestamp deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelivery() { return  this.delivery; }

    public void setDelivery(String delivery) { this.delivery = delivery; }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Amount getBedragen() {
        return bedragen;
    }

    public void setBedragen(Amount bedragen) {
        this.bedragen = bedragen;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Contact contact;
    private Amount bedragen;

    /**
     *
     * @param name
     */
    public Invoice(String name, Amount amount, String delivery) {
        this.name = name;
        this.amount = amount;
        this.delivery = delivery;
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

    public void generatePdf() throws ParseException {
        //TODO: put invoice as parameter
        Tax tax = new Tax("btw", 21);
        Project project = new Project("Sander`s project", "open");
        Contact contact = new Contact("HeinekenBV", "Henk", "Jandeberg", "Zoeterwoudeweg", "15", "2254BB", "Leiden");
        Amount amount = new Amount(831.51, 15.0, "Henk Jandeberg");
        project.setContactList(contact);

//        this = new Invoice("Factuur 4522", amount, "infographic");
        this.setName("Factuur 4522");
        this.setAmount(amount);
        this.setDelivery("infographic");
        this.setId(5);
        this.setProject(project);
        this.setTax(tax);
        this.getTax().setTaxPart(this.calculateTax(this));
        String value = df.format(this.getTax().getTaxPart()+this.getAmount().getPrice());
        this.getAmount().setBcost((Double)df.parse(value));

        try {
            PdfService.getInstance().generateInvoicePdf(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public double calculateTax(Invoice invoice) {
        double taxPart = invoice.getAmountPrice() * (new Double(invoice.getTax().getPercentage()) / 100);
        taxPart = Math.round(taxPart * 100.0) / 100.0;
        return taxPart;
    }

}