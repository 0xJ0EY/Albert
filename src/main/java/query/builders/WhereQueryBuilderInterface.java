package query.builders;

import query.WhereQuery;

// TODO: Auto-generated Javadoc
/**
 * The Interface WhereQueryBuilderInterface.
 * @author
 */
public interface WhereQueryBuilderInterface extends QueryBuilderInterface {

    /**
     * Where.
     *
     * @param key the key
     * @param operator the operator
     */
    public void where(String key, String operator);

    /**
     * Or where.
     *
     * @param key the key
     * @param operator the operator
     */
    public void orWhere(String key, String operator);

    /**
     * Where.
     *
     * @param query the query
     */
    public void where(WhereQuery query);

    /**
     * Or where.
     *
     * @param query the query
     */
    public void orWhere(WhereQuery query);

    /**
     * Clear where.
     */
    public void clearWhere();

}
