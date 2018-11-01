package query.builders;

import query.WhereQuery;
import query.selects.Select;

import java.util.ArrayList;

public class QueryBuilder implements
        SelectQueryBuilderInterface,
        WhereQueryBuilderInterface,
        TableQueryBuilderInterface,
        LimitQueryBuilderInterface,
        OffsetQueryBuilderInterface {

    private SelectQueryBuilder selectQueryBuilder = new SelectQueryBuilder();
    private TableQueryBuilder tableQueryBuilder = new TableQueryBuilder();
    private WhereQueryBuilder whereQueryBuilder = new WhereQueryBuilder();
    private LimitQueryBuilder limitQueryBuilder = new LimitQueryBuilder();
    private OffsetQueryBuilder offsetQueryBuilder = new OffsetQueryBuilder();

    public QueryBuilder() {}

    // Copy constructor
    public QueryBuilder(QueryBuilder qb) {
        this.selectQueryBuilder = qb.selectQueryBuilder;
        this.tableQueryBuilder = qb.tableQueryBuilder;
        this.whereQueryBuilder = qb.whereQueryBuilder;
        this.limitQueryBuilder = qb.limitQueryBuilder;
        this.offsetQueryBuilder = qb.offsetQueryBuilder;
    }

    @Override
    public void select(String key) {
        this.selectQueryBuilder.select(key);
    }

    @Override
    public ArrayList<Select> getSelected() {
        return this.selectQueryBuilder.getSelected();
    }

    @Override
    public void clearSelect() {
        this.selectQueryBuilder.clearSelect();
    }

    @Override
    public void table(String table) {
        this.tableQueryBuilder.table(table);
    }

    @Override
    public void where(String key, String operator) {
        this.whereQueryBuilder.where(key, operator);
    }

    @Override
    public void orWhere(String key, String operator) {
        this.whereQueryBuilder.orWhere(key, operator);
    }

    @Override
    public void where(WhereQuery query) {
        this.whereQueryBuilder.where(query);
    }

    @Override
    public void orWhere(WhereQuery query) {
        this.whereQueryBuilder.orWhere(query);
    }

    @Override
    public void clearWhere() {
        this.whereQueryBuilder.clearWhere();
    }

    @Override
    public void limit(int limit) {
        this.limitQueryBuilder.limit(limit);
    }

    @Override
    public void clearLimit() {
        this.limitQueryBuilder.clearLimit();
    }

    @Override
    public void offset(int offset) {
        this.offsetQueryBuilder.offset(offset);
    }

    @Override
    public void clearOffset() {
        this.offsetQueryBuilder.clearOffset();
    }

    @Override
    public String build() {

        StringBuilder query = new StringBuilder();

        query.append(this.selectQueryBuilder.build());

        query.append(this.tableQueryBuilder.build());

        String where = this.whereQueryBuilder.build();

        if (where.length() > 0) {
            query.append(" WHERE ");
            query.append(where);
        }

        query.append(this.limitQueryBuilder.build());

        query.append(this.offsetQueryBuilder.build());

        return query.toString();
    }

}
