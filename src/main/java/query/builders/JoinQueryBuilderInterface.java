package query.builders;

// TODO: Auto-generated Javadoc
/**
 * The Interface JoinQueryBuilderInterface.
 * @author
 */
public interface JoinQueryBuilderInterface extends QueryBuilderInterface {

    /**
     * Join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     */
    public void join(String table, String key, String operator, String value);

    /**
     * Left join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     */
    public void leftJoin(String table, String key, String operator, String value);

    /**
     * Right join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     */
    public void rightJoin(String table, String key, String operator, String value);

}
