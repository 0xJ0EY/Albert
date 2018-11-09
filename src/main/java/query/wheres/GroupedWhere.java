package query.wheres;

import query.WhereQuery;

/**
 * The Class GroupedWhere.
 *
 */
public class GroupedWhere implements WhereStatement {

    /** The query. */
    private WhereQuery query;

    /**
     * Instantiates a new grouped where.
     *
     * @param query the query
     */
    public GroupedWhere(WhereQuery query) {
        this.query = query;
    }

    /* (non-Javadoc)
     * @see query.wheres.WhereStatement#create(boolean)
     */
    @Override
    public String create(boolean first) {
        return (first ? "" : "AND ") + "(" + query.createQuery() + ") ";
    }

}
