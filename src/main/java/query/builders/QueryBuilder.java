package query.builders;

import query.WhereQuery;
import query.selects.Select;

import java.util.ArrayList;

/**
 * The Class QueryBuilder.
 *
 */
public class QueryBuilder implements
        SelectQueryBuilderInterface,
        WhereQueryBuilderInterface,
        JoinQueryBuilderInterface,
        TableQueryBuilderInterface,
        GroupByQueryBuilderInterface,
        OrderByQueryBuilderInterface,
        LimitQueryBuilderInterface,
        OffsetQueryBuilderInterface {

    /** The select query builder. */
    private SelectQueryBuilder selectQueryBuilder = new SelectQueryBuilder();
    
    /** The table query builder. */
    private TableQueryBuilder tableQueryBuilder = new TableQueryBuilder();
    
    /** The join query builder. */
    private JoinQueryBuilder joinQueryBuilder = new JoinQueryBuilder();
    
    /** The where query builder. */
    private WhereQueryBuilder whereQueryBuilder = new WhereQueryBuilder();
    
    /** The group by query builder. */
    private GroupByQueryBuilder groupByQueryBuilder = new GroupByQueryBuilder();
    
    /** The order by query builder. */
    private OrderByQueryBuilder orderByQueryBuilder = new OrderByQueryBuilder();
    
    /** The limit query builder. */
    private LimitQueryBuilder limitQueryBuilder = new LimitQueryBuilder();
    
    /** The offset query builder. */
    private OffsetQueryBuilder offsetQueryBuilder = new OffsetQueryBuilder();

    /**
     * Instantiates a new query builder.
     */
    public QueryBuilder() {}

    /* (non-Javadoc)
     * @see query.builders.SelectQueryBuilderInterface#select(java.lang.String)
     */
    @Override
    public void select(String key) {
        this.selectQueryBuilder.select(key);
    }

    /* (non-Javadoc)
     * @see query.builders.SelectQueryBuilderInterface#getSelected()
     */
    @Override
    public ArrayList<Select> getSelected() {
        return this.selectQueryBuilder.getSelected();
    }

    /* (non-Javadoc)
     * @see query.builders.SelectQueryBuilderInterface#clearSelect()
     */
    @Override
    public void clearSelect() {
        this.selectQueryBuilder.clearSelect();
    }

    /* (non-Javadoc)
     * @see query.builders.TableQueryBuilderInterface#table(java.lang.String)
     */
    @Override
    public void table(String table) {
        this.tableQueryBuilder.table(table);
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#where(java.lang.String, java.lang.String)
     */
    @Override
    public void where(String key, String operator) {
        this.whereQueryBuilder.where(key, operator);
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#orWhere(java.lang.String, java.lang.String)
     */
    @Override
    public void orWhere(String key, String operator) {
        this.whereQueryBuilder.orWhere(key, operator);
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#where(query.WhereQuery)
     */
    @Override
    public void where(WhereQuery query) {
        this.whereQueryBuilder.where(query);
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#orWhere(query.WhereQuery)
     */
    @Override
    public void orWhere(WhereQuery query) {
        this.whereQueryBuilder.orWhere(query);
    }

    /* (non-Javadoc)
     * @see query.builders.JoinQueryBuilderInterface#join(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void join(String table, String key, String operator, String value) {
        this.joinQueryBuilder.join(table, key, operator, value);
    }

    /* (non-Javadoc)
     * @see query.builders.JoinQueryBuilderInterface#leftJoin(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void leftJoin(String table, String key, String operator, String value) {
        this.joinQueryBuilder.leftJoin(table, key, operator, value);
    }

    /* (non-Javadoc)
     * @see query.builders.JoinQueryBuilderInterface#rightJoin(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void rightJoin(String table, String key, String operator, String value) {
        this.joinQueryBuilder.rightJoin(table, key, operator, value);
    }

    /* (non-Javadoc)
     * @see query.builders.WhereQueryBuilderInterface#clearWhere()
     */
    @Override
    public void clearWhere() {
        this.whereQueryBuilder.clearWhere();
    }

    /* (non-Javadoc)
     * @see query.builders.OrderByQueryBuilderInterface#orderBy(java.lang.String, java.lang.String)
     */
    @Override
    public void orderBy(String value, String direction) {
        this.orderByQueryBuilder.orderBy(value, direction);
    }

    /* (non-Javadoc)
     * @see query.builders.OrderByQueryBuilderInterface#clearOrderBy()
     */
    @Override
    public void clearOrderBy() {
        this.orderByQueryBuilder.clearOrderBy();
    }

    /* (non-Javadoc)
     * @see query.builders.LimitQueryBuilderInterface#limit(int)
     */
    @Override
    public void limit(int limit) {
        this.limitQueryBuilder.limit(limit);
    }

    /* (non-Javadoc)
     * @see query.builders.LimitQueryBuilderInterface#clearLimit()
     */
    @Override
    public void clearLimit() {
        this.limitQueryBuilder.clearLimit();
    }

    /* (non-Javadoc)
     * @see query.builders.GroupByQueryBuilderInterface#groupBy(java.lang.String)
     */
    @Override
    public void groupBy(String value) {
        this.groupByQueryBuilder.groupBy(value);
    }

    /* (non-Javadoc)
     * @see query.builders.OffsetQueryBuilderInterface#offset(int)
     */
    @Override
    public void offset(int offset) {
        this.offsetQueryBuilder.offset(offset);
    }

    /* (non-Javadoc)
     * @see query.builders.OffsetQueryBuilderInterface#clearOffset()
     */
    @Override
    public void clearOffset() {
        this.offsetQueryBuilder.clearOffset();
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {

        StringBuilder query = new StringBuilder();

        query.append(this.selectQueryBuilder.build());

        query.append(this.tableQueryBuilder.build());

        query.append(this.joinQueryBuilder.build());

        String where = this.whereQueryBuilder.build();

        if (where.length() > 0) {
            query.append(" WHERE ");
            query.append(where);
        }

        query.append(this.groupByQueryBuilder.build());

        query.append(this.orderByQueryBuilder.build());

        query.append(this.limitQueryBuilder.build());

        query.append(this.offsetQueryBuilder.build());

        return query.toString();
    }

}
