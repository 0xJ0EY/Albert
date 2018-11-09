package query.builders;

// TODO: Auto-generated Javadoc
/**
 * The Class LimitQueryBuilder.
 * @author
 */
public class LimitQueryBuilder implements LimitQueryBuilderInterface {

    /** The format. */
    private final String format = " LIMIT %d";
    
    /** The limit. */
    private int limit = -1;

    /* (non-Javadoc)
     * @see query.builders.LimitQueryBuilderInterface#limit(int)
     */
    @Override
    public void limit(int limit) {
        this.limit = limit;
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {
        if (limit < 0)
            return "";

        return String.format(this.format, this.limit);
    }

    /* (non-Javadoc)
     * @see query.builders.LimitQueryBuilderInterface#clearLimit()
     */
    @Override
    public void clearLimit() {
        this.limit = -1;
    }
}
