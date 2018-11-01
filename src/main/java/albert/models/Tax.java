package albert.models;

public class Tax {

    private String id;
    private int percentage;
    private String name;

    public void tax(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public int getPercentage() { return this.percentage; }

}
