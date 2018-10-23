package table.dao.db;

import table.dao.db.builders.WhereQueryBuilder;

import java.util.ArrayList;

public class WhereDB implements WhereQuery {

    private WhereQueryBuilder queryBuilder = new WhereQueryBuilder();

    @Override
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

    @Override
    public String get() {
        return this.queryBuilder.build();
    }
}
