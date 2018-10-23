package table.dao.db.wheres;

public class Where implements WhereStatement {

    private String key;
    private String operator;
    private Object value;

    public Where(String key, String operator, Object value) {
        this.key = key;
        this.operator = operator;
        this.value = value;
    }

    public String create(boolean first) {
        return (first ? "" : "AND ") + this.key + " " + this.operator + " ? ";
    }

}
