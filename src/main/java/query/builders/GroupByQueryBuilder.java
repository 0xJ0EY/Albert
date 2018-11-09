package query.builders;

import query.groupby.GroupBy;
import query.selects.Select;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class GroupByQueryBuilder.
 * @author
 */
public class GroupByQueryBuilder implements GroupByQueryBuilderInterface {

    /** The groups. */
    private ArrayList<GroupBy> groups = new ArrayList<>();

    /* (non-Javadoc)
     * @see query.builders.GroupByQueryBuilderInterface#groupBy(java.lang.String)
     */
    @Override
    public void groupBy(String value) {
        this.groups.add(new GroupBy(value));
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {

        if (this.groups.size() == 0)
            return "";

        ArrayList<String> groupies = new ArrayList<>();

        for (GroupBy group : this.groups) {
            groupies.add(group.build());
        }

        return " GROUP BY " + String.join(",", groupies);
    }
}
