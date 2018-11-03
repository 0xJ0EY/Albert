package albert.models;

public class Tax {

    private int id;
    private int percentage;
    private String name;
    private double taxPart;

    public Tax(String name, int percentage) {
        this.name = name;
        this.percentage = percentage; }

    public Tax() {

    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public int getPercentage() { return this.percentage; }

    public Double getTaxPart() { return this.taxPart; }

    public void setTaxPart(double taxPart) { this.taxPart = taxPart; }

}
