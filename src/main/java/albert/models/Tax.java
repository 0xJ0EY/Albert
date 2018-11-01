package albert.models;

public class Tax {

    private int id;
    private int percentage;
    private String name;

    public void tax(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public int getPercentage() { return this.percentage; }

    public int getId() {
        return id;
    }
}
