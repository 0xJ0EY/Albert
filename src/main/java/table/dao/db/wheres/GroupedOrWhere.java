package table.dao.db.wheres;

import table.dao.db.WhereQuery;

public class GroupedOrWhere implements WhereStatement {

    private WhereQuery query;

    public GroupedOrWhere(WhereQuery query) {
        this.query = query;
    }

    @Override
    public String create(boolean first) {
        return (first ? "" : "OR ") + "(" + query.createQuery() + ") ";
    }

}
