package table.dao.db.builders;

import table.dao.db.WhereQuery;
import table.dao.db.wheres.*;

import java.util.ArrayList;

public class WhereQueryBuilder implements WhereQueryBuilderInterface {

    private ArrayList<WhereStatement> wheres = new ArrayList<>();

    public void where(String key, String operator) {
        this.wheres.add(new Where(key, operator));
    }

    public void orWhere(String key, String operator) {
        this.wheres.add(new OrWhere(key, operator));
    }

    public void where(WhereQuery query) {
        this.wheres.add(new GroupedWhere(query));
    }

    public void orWhere(WhereQuery query) {
        this.wheres.add(new GroupedOrWhere(query));
    }

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

    @Override
    public void clearWhere() {
        this.wheres = new ArrayList<>();
    }
}
