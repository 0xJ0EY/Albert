package query.wheres;

import query.WhereQuery;

/**
 * The Class GroupedOrWhere.
 *
 */
public class GroupedOrWhere implements WhereStatement {

    /** The query. */
    private WhereQuery query;

    /**
     * Instantiates a new grouped or where.
     *
     * @param query the query
     */
    public GroupedOrWhere(WhereQuery query) {
        this.query = query;
    }

    /* (non-Javadoc)
     * @see query.wheres.WhereStatement#create(boolean)
     */
    @Override
    public String create(boolean first) {
        return (first ? "" : "OR ") + "(" + query.createQuery() + ") ";
    }

}
