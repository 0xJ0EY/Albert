package query.joins;

/**
 * The Class LeftJoin.
 *
 */
public class LeftJoin implements JoinStatement {

    /** The table. */
    private String table;
    
    /** The key. */
    private String key;
    
    /** The operator. */
    private String operator;
    
    /** The value. */
    private String value;

    /**
     * Instantiates a new left join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     */
    public LeftJoin(String table, String key, String operator, String value) {
        this.table = table;
        this.key = key;
        this.operator = operator;
        this.value = value;

    }

    /* (non-Javadoc)
     * @see query.joins.JoinStatement#create()
     */
    @Override
    public String create() {
        return " LEFT JOIN " + this.table + " ON " + this.key + " " + this.operator + " " + this.value;
    }

}
