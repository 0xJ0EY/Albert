package query.builders;

import query.WhereQuery;
import query.selects.Select;

import java.util.ArrayList;

public class QueryBuilder implements
        SelectQueryBuilderInterface,
        WhereQueryBuilderInterface,
        JoinQueryBuilderInterface,
        TableQueryBuilderInterface,
        GroupByQueryBuilderInterface,
        LimitQueryBuilderInterface,
        OffsetQueryBuilderInterface {

    private SelectQueryBuilder selectQueryBuilder = new SelectQueryBuilder();
    private TableQueryBuilder tableQueryBuilder = new TableQueryBuilder();
    private JoinQueryBuilder joinQueryBuilder = new JoinQueryBuilder();
    private WhereQueryBuilder whereQueryBuilder = new WhereQueryBuilder();
    private GroupByQueryBuilder groupByQueryBuilder = new GroupByQueryBuilder();
    private LimitQueryBuilder limitQueryBuilder = new LimitQueryBuilder();
    private OffsetQueryBuilder offsetQueryBuilder = new OffsetQueryBuilder();

    public QueryBuilder() {}

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
    public void join(String table, String key, String operator, String value) {
        this.joinQueryBuilder.join(table, key, operator, value);
    }

    @Override
    public void leftJoin(String table, String key, String operator, String value) {
        this.joinQueryBuilder.leftJoin(table, key, operator, value);
    }

    @Override
    public void rightJoin(String table, String key, String operator, String value) {
        this.joinQueryBuilder.rightJoin(table, key, operator, value);
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
    public void groupBy(String value) {
        this.groupByQueryBuilder.groupBy(value);
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

        query.append(this.joinQueryBuilder.build());

        String where = this.whereQueryBuilder.build();

        if (where.length() > 0) {
            query.append(" WHERE ");
            query.append(where);
        }

        query.append(this.groupByQueryBuilder.build());

        query.append(this.limitQueryBuilder.build());

        query.append(this.offsetQueryBuilder.build());

        return query.toString();
    }

}
