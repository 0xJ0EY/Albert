package query.wheres;

// TODO: Auto-generated Javadoc
/**
 * The Class OrWhere.
 * @author
 */
public class OrWhere implements WhereStatement {
    
    /** The key. */
    private String key;
    
    /** The operator. */
    private String operator;

    /**
     * Instantiates a new or where.
     *
     * @param key the key
     * @param operator the operator
     */
    public OrWhere(String key, String operator) {
        this.key = key;
        this.operator = operator;
    }

    /* (non-Javadoc)
     * @see query.wheres.WhereStatement#create(boolean)
     */
    public String create(boolean first) {
        return (first ? " " : "OR ") + this.key + " " + this.operator + " ? ";
    }

}
