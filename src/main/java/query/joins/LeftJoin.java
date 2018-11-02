package query.joins;

public class LeftJoin implements JoinStatement {

    private String table;
    private String key;
    private String operator;
    private String value;

    public LeftJoin(String table, String key, String operator, String value) {
        this.table = table;
        this.key = key;
        this.operator = operator;
        this.value = value;

    }

    @Override
    public String create() {
        return " LEFT JOIN " + this.table + " ON " + this.key + " " + this.operator + " " + this.value;
    }

}
