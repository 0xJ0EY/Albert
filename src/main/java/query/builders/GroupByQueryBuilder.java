package query.builders;

import query.groupby.GroupBy;
import query.selects.Select;

import java.util.ArrayList;

public class GroupByQueryBuilder implements GroupByQueryBuilderInterface {

    private ArrayList<GroupBy> groups = new ArrayList<>();

    @Override
    public void groupBy(String value) {
        this.groups.add(new GroupBy(value));
    }

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
