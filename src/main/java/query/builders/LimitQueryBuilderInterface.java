package query.builders;

/**
 * The Interface LimitQueryBuilderInterface.
 *
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
