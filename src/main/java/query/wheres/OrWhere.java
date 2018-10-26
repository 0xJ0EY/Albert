package query.wheres;

public class OrWhere implements WhereStatement {
    private String key;
    private String operator;

    public OrWhere(String key, String operator) {
        this.key = key;
        this.operator = operator;
    }

    public String create(boolean first) {
        return (first ? " " : "OR ") + this.key + " " + this.operator + " ? ";
    }

}
