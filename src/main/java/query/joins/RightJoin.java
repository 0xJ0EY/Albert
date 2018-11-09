package query.joins;

// TODO: Auto-generated Javadoc
/**
 * The Class RightJoin.
 * @author
 */
public class RightJoin implements JoinStatement {

    /** The table. */
    private String table;
    
    /** The key. */
    private String key;
    
    /** The operator. */
    private String operator;
    
    /** The value. */
    private String value;

    /**
     * Instantiates a new right join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     */
    public RightJoin(String table, String key, String operator, String value) {
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
        return " RIGHT JOIN " + this.table + " ON " + this.key + " " + this.operator + " " + this.value;
    }

}
