package query.builders;

import query.orderby.OrderBy;

import java.util.ArrayList;

/**
 * The Class OrderByQueryBuilder.
 *
 */
public class OrderByQueryBuilder implements OrderByQueryBuilderInterface {

    /** The order by. */
    private ArrayList<OrderBy> orderBy = new ArrayList<>();

    /* (non-Javadoc)
     * @see query.builders.OrderByQueryBuilderInterface#orderBy(java.lang.String, java.lang.String)
     */
    @Override
    public void orderBy(String value, String direction) {
        this.orderBy.add(new OrderBy(value, direction));
    }

    /* (non-Javadoc)
     * @see query.builders.OrderByQueryBuilderInterface#clearOrderBy()
     */
    @Override
    public void clearOrderBy() {
        this.orderBy = new ArrayList<>();
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {
        ArrayList<String> parts = new ArrayList<>();

        for (OrderBy order : this.orderBy)
            parts.add(order.build());

        return this.orderBy.size() > 0 ? " ORDER BY " + String.join(", ", parts) : "";
    }
}
