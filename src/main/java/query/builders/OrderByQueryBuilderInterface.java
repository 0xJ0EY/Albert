package query.builders;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrderByQueryBuilderInterface.
 * @author
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
