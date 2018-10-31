package query;

import query.builders.WhereQueryBuilder;

import java.util.ArrayList;

public class WhereDB implements WhereQuery {

    private ArrayList<Object> values = new ArrayList<>();
    private WhereQueryBuilder queryBuilder = new WhereQueryBuilder();

    @Override
    public WhereQuery where(String key, String operator, Object value) {
        this.queryBuilder.where(key, operator);
        this.values.add(value);
        return this;
    }

    @Override
    public WhereQuery orWhere(String key, String operator, Object value) {
        this.queryBuilder.orWhere(key, operator);
        this.values.add(value);
        return this;
    }

    @Override
    public WhereQuery where(WhereQueryLambda query) {

        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.where(q);

        System.out.println("child.getValues() = " + child.getValues());
        return this;
    }

    @Override
    public WhereQuery orWhere(WhereQueryLambda query) {

        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.orWhere(q);

        System.out.println("child.getValues() = " + child.getValues());
        return this;
    }

    @Override
    public ArrayList<Object> getValues() {
        return this.values;
    }

    @Override
    public String createQuery() {
        return this.queryBuilder.build();
    }
}
