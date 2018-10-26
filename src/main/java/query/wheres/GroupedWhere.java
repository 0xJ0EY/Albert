package table.dao.db.wheres;

import table.dao.db.WhereQuery;

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
