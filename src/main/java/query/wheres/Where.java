package query.wheres;

public class Where implements WhereStatement {

    private String key;
    private String operator;

    public Where(String key, String operator) {
        this.key = key;
        this.operator = operator;
    }

    public String create(boolean first) {
        return (first ? "" : "AND ") + this.key + " " + this.operator + " ? ";
    }

}
