package query;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Interface WhereQuery.
 *
 */
public interface WhereQuery extends Serializable {

    /**
     * Where.
     *
     * @param key the key
     * @param operator the operator
     * @param value the value
     * @return the where query
     */
    public WhereQuery where(String key, String operator, Object value);

    /**
     * Or where.
     *
     * @param key the key
     * @param operator the operator
     * @param value the value
     * @return the where query
     */
    public WhereQuery orWhere(String key, String operator, Object value);

    /**
     * Where.
     *
     * @param query the query
     * @return the where query
     */
    public WhereQuery where(WhereQueryLambda query);

    /**
     * Or where.
     *
     * @param query the query
     * @return the where query
     */
    public WhereQuery orWhere(WhereQueryLambda query);

    /**
     * Gets the values.
     *
     * @return the values
     */
    public ArrayList<Object> getValues();

    /**
     * Creates the query.
     *
     * @return the string
     */
    public String createQuery();

}
