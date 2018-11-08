package query.orderby;

public class OrderBy implements OrderByStatement {

    private String name;
    private String direction;

    public OrderBy(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

    @Override
    public String build() {
        return this.name + " " + this.direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
