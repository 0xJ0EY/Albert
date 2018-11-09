package query;

import query.builders.WhereQueryBuilder;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class WhereDB.
 * @author
 */
public class WhereDB implements WhereQuery {

    /** The values. */
    private ArrayList<Object> values = new ArrayList<>();
    
    /** The query builder. */
    private WhereQueryBuilder queryBuilder = new WhereQueryBuilder();

    /* (non-Javadoc)
     * @see query.WhereQuery#where(java.lang.String, java.lang.String, java.lang.Object)
     */
    @Override
    public WhereQuery where(String key, String operator, Object value) {
        this.queryBuilder.where(key, operator);
        this.values.add(value);
        return this;
    }

    /* (non-Javadoc)
     * @see query.WhereQuery#orWhere(java.lang.String, java.lang.String, java.lang.Object)
     */
    @Override
    public WhereQuery orWhere(String key, String operator, Object value) {
        this.queryBuilder.orWhere(key, operator);
        this.values.add(value);
        return this;
    }

    /* (non-Javadoc)
     * @see query.WhereQuery#where(query.WhereQueryLambda)
     */
    @Override
    public WhereQuery where(WhereQueryLambda query) {

        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.where(q);

        System.out.println("child.getValues() = " + child.getValues());
        return this;
    }

    /* (non-Javadoc)
     * @see query.WhereQuery#orWhere(query.WhereQueryLambda)
     */
    @Override
    public WhereQuery orWhere(WhereQueryLambda query) {

        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.orWhere(q);

        System.out.println("child.getValues() = " + child.getValues());
        return this;
    }

    /* (non-Javadoc)
     * @see query.WhereQuery#getValues()
     */
    @Override
    public ArrayList<Object> getValues() {
        return this.values;
    }

    /* (non-Javadoc)
     * @see query.WhereQuery#createQuery()
     */
    @Override
    public String createQuery() {
        return this.queryBuilder.build();
    }
}
