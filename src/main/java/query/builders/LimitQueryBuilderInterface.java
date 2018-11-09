package query.builders;

// TODO: Auto-generated Javadoc
/**
 * The Interface LimitQueryBuilderInterface.
 * @author
 */
public interface LimitQueryBuilderInterface extends QueryBuilderInterface {

    /**
     * Limit.
     *
     * @param limit the limit
     */
    public void limit(int limit);

    /**
     * Clear limit.
     */
    public void clearLimit();

}
