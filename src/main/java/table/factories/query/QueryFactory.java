package table.factories.query;

/**
 * A factory for creating Query objects.
 *
 */
public interface QueryFactory {

    /**
     * Select query.
     *
     * @return the string
     */
    public String selectQuery();

    /**
     * Count query.
     *
     * @return the string
     */
    public String countQuery();

}
