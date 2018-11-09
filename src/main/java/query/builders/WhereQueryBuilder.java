package query.builders;

import query.WhereQuery;
import query.wheres.*;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class WhereQueryBuilder.
 * @author
 */
public class WhereQueryBuilder implements WhereQueryBuilderInterface {

    /** The wheres. */
    private ArrayList<WhereStatement> wheres = new ArrayList<>();

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#where(java.lang.String, java.lang.String)
     */
    public void where(String key, String operator) {
        this.wheres.add(new Where(key, operator));
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#orWhere(java.lang.String, java.lang.String)
     */
    public void orWhere(String key, String operator) {
        this.wheres.add(new OrWhere(key, operator));
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#where(query.WhereQuery)
     */
    public void where(WhereQuery query) {
        this.wheres.add(new GroupedWhere(query));
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#orWhere(query.WhereQuery)
     */
    public void orWhere(WhereQuery query) {
        this.wheres.add(new GroupedOrWhere(query));
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {

        StringBuilder query = new StringBuilder();

        boolean isFirst = true;

        for (WhereStatement statement : this.wheres) {

            query.append(statement.create(isFirst));

            isFirst = false;
        }
        
        return query.toString();
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#clearWhere()
     */
    @Override
    public void clearWhere() {
        this.wheres = new ArrayList<>();
    }
}
