package query.builders;

/**
 * The Interface OffsetQueryBuilderInterface.
 *
 */
public interface OffsetQueryBuilderInterface extends QueryBuilderInterface {

    /**
     * Offset.
     *
     * @param offset the offset
     */
    public void offset(int offset);

    /**
     * Clear offset.
     */
    public void clearOffset();

}
