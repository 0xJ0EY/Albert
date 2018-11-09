package query.builders;

/**
 * The Class TableQueryBuilder.
 *
 */
public class TableQueryBuilder implements TableQueryBuilderInterface {

    /** The table. */
    private String table;

    /**
     * Instantiates a new table query builder.
     */
    public TableQueryBuilder() {
    }

    /**
     * Instantiates a new table query builder.
     *
     * @param table the table
     */
    public TableQueryBuilder(TableQueryBuilder table) {
        this.table = table.table;
    }

    /* (non-Javadoc)
     * @see query.builders.TableQueryBuilderInterface#table(java.lang.String)
     */
    @Override
    public void table(String table) {
        this.table = table;
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {
        return " FROM " + this.table;
    }
}
