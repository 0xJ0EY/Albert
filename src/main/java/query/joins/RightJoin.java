package query.joins;

public class RightJoin implements JoinStatement {

    private String table;
    private String key;
    private String operator;
    private String value;

    public RightJoin(String table, String key, String operator, String value) {
        this.table = table;
        this.key = key;
        this.operator = operator;
        this.value = value;

    }

    @Override
    public String create() {
        return " RIGHT JOIN " + this.table + " ON " + this.key + " " + this.operator + " " + this.value;
    }

}
