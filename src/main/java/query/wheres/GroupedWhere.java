package query.wheres;

import query.WhereQuery;

public class GroupedWhere implements WhereStatement {

    private WhereQuery query;

    public GroupedWhere(WhereQuery query) {
        this.query = query;
    }

    @Override
    public String create(boolean first) {
        return (first ? "" : "AND ") + "(" + query.createQuery() + ") ";
    }

}
