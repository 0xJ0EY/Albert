package query.wheres;

/**
 * The Class Where.
 *
 */
public class Where implements WhereStatement {

    /** The key. */
    private String key;
    
    /** The operator. */
    private String operator;

    /**
     * Instantiates a new where.
     *
     * @param key the key
     * @param operator the operator
     */
    public Where(String key, String operator) {
        this.key = key;
        this.operator = operator;
    }

    /* (non-Javadoc)
     * @see query.wheres.WhereStatement#create(boolean)
     */
    public String create(boolean first) {
        return (first ? "" : "AND ") + this.key + " " + this.operator + " ? ";
    }

}
