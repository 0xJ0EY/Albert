package query.builders;

import query.WhereQuery;
import query.joins.Join;
import query.joins.JoinStatement;
import query.joins.LeftJoin;
import query.joins.RightJoin;
import query.wheres.GroupedWhere;
import query.wheres.Where;

import java.util.ArrayList;

public class JoinQueryBuilder implements JoinQueryBuilderInterface {

    private ArrayList<JoinStatement> joins = new ArrayList<>();

    @Override
    public void join(String table, String key, String operator, String value) {
        this.joins.add(new Join(table, key, operator, value));
    }

    @Override
    public void leftJoin(String table, String key, String operator, String value) {
        this.joins.add(new LeftJoin(table, key, operator, value));
    }

    @Override
    public void rightJoin(String table, String key, String operator, String value) {
        this.joins.add(new RightJoin(table, key, operator, value));
    }

    @Override
    public String build() {

        StringBuilder query = new StringBuilder();

        for (JoinStatement join : this.joins) {
            query.append(join.create());
        }

        return query.toString();
    }
}
