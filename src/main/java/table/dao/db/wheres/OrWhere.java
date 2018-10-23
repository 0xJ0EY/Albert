package table.dao.db.wheres;

public class OrWhere implements WhereStatement {
    private String key;
    private String operator;
    private Object value;

    public OrWhere(String key, String operator, Object value) {
        this.key = key;
        this.operator = operator;
        this.value = value;
    }

    public String create(boolean first) {
        return (first ? " " : "OR ") + this.key + " " + this.operator + " ? ";
    }

}
