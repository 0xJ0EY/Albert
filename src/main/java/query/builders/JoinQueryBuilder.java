package query.builders;

import query.WhereQuery;
import query.joins.Join;
import query.joins.JoinStatement;
import query.joins.LeftJoin;
import query.joins.RightJoin;
import query.wheres.GroupedWhere;
import query.wheres.Where;

import java.util.ArrayList;

/**
 * The Class JoinQueryBuilder.
 *
 */
public class JoinQueryBuilder implements JoinQueryBuilderInterface {

    /** The joins. */
    private ArrayList<JoinStatement> joins = new ArrayList<>();

    /* (non-Javadoc)
     * @see query.builders.JoinQueryBuilderInterface#join(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void join(String table, String key, String operator, String value) {
        this.joins.add(new Join(table, key, operator, value));
    }

    /* (non-Javadoc)
     * @see query.builders.JoinQueryBuilderInterface#leftJoin(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void leftJoin(String table, String key, String operator, String value) {
        this.joins.add(new LeftJoin(table, key, operator, value));
    }

    /* (non-Javadoc)
     * @see query.builders.JoinQueryBuilderInterface#rightJoin(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void rightJoin(String table, String key, String operator, String value) {
        this.joins.add(new RightJoin(table, key, operator, value));
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {

        StringBuilder query = new StringBuilder();

        for (JoinStatement join : this.joins) {
            query.append(join.create());
        }

        return query.toString();
    }
}
