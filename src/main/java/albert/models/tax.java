package albert.models;

public class tax {

    private String id;
    private int percentage;
    private String name;

    //TODO: make get en set alles
    public void tax(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public int getPercentage() { return this.percentage; }

}
