package query.groupby;


/**
 * The Class GroupBy.
 *
 */
public class GroupBy implements GroupByStatement {

    /** The value. */
    private String value;

    /**
     * Instantiates a new group by.
     *
     * @param value the value
     */
    public GroupBy(String value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see query.groupby.GroupByStatement#build()
     */
    @Override
    public String build() {
        return this.value;
    }
}
