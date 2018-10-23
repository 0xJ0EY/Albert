package table.dao.db;

import table.dao.db.builders.QueryBuilder;

public class DB implements WhereQuery {

    private String table;

    private QueryBuilder queryBuilder;

    public static DB table(String table) {
        return new DB(table);
    }

    private DB(String table) {
        this.queryBuilder = new QueryBuilder();
    }

    public WhereQuery where(String key, String operator, Object value) {
        this.queryBuilder.where(key, operator, value);
        return this;
    }

    @Override
    public WhereQuery orWhere(String key, String operator, Object value) {
        this.queryBuilder.orWhere(key, operator, value);
        return this;
    }

    @Override
    public WhereQuery where(WhereQueryLambda query) {
        WhereQuery q = query.query(new WhereDB());
        this.queryBuilder.where(q);
        return this;
    }

    @Override
    public WhereQuery orWhere(WhereQueryLambda query) {
        WhereQuery q = query.query(new WhereDB());
        this.queryBuilder.orWhere(q);
        return this;
    }

    public String get() {
        return this.queryBuilder.build();
    }

}
