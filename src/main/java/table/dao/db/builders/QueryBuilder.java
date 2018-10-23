package table.dao.db.builders;

import table.dao.db.WhereQuery;

public class QueryBuilder implements WhereQueryBuilderInterface {

    private String table;
    private WhereQueryBuilder whereQueryBuilder = new WhereQueryBuilder();

    public void where(String key, String operator, Object value) {
        this.whereQueryBuilder.where(key, operator, value);
    }

    public void orWhere(String key, String operator, Object value) {
        this.whereQueryBuilder.orWhere(key, operator, value);
    }

    public void where(WhereQuery query) {
        this.whereQueryBuilder.where(query);
    }

    public void orWhere(WhereQuery query) {
        this.whereQueryBuilder.orWhere(query);
    }

    public String build() {
        return whereQueryBuilder.build();
    }

}
