package query.builders;

// TODO: Auto-generated Javadoc
/**
 * The Class OffsetQueryBuilder.
 * @author
 */
public class OffsetQueryBuilder implements OffsetQueryBuilderInterface {

    /** The format. */
    private final String format = " OFFSET %d";
    
    /** The offset. */
    private int offset = -1;

    /* (non-Javadoc)
     * @see query.builders.OffsetQueryBuilderInterface#offset(int)
     */
    @Override
    public void offset(int offset) {
        this.offset = offset;

    }

    /* (non-Javadoc)
     * @see query.builders.OffsetQueryBuilderInterface#clearOffset()
     */
    @Override
    public void clearOffset() {
        this.offset = -1;
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {
        if (this.offset < 0)
            return "";

        return String.format(this.format, this.offset);
    }
}
