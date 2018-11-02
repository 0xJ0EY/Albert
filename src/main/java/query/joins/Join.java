package query.joins;

public class Join implements JoinStatement {

    private String table;
    private String key;
    private String operator;
    private String value;

    public Join(String table, String key, String operator, String value) {
        this.table = table;
        this.key = key;
        this.operator = operator;
        this.value = value;

    }

    @Override
    public String create() {
        return " JOIN " + this.table + " ON " + this.key + " " + this.operator + " " + this.value;
    }

}
