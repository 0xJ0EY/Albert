package query.builders;

/**
 * The Interface OrderByQueryBuilderInterface.
 *
 */
public interface OrderByQueryBuilderInterface extends QueryBuilderInterface {

    /**
     * Order by.
     *
     * @param value the value
     * @param direction the direction
     */
    public void orderBy(String value, String direction);

    /**
     * Clear order by.
     */
    public void clearOrderBy();

}
