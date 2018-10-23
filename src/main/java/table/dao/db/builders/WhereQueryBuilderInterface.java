package table.dao.db.builders;

import table.dao.db.WhereQuery;

public interface WhereQueryBuilderInterface {

    public void where(String key, String operator, Object value);

    public void orWhere(String key, String operator, Object value);

    public void where(WhereQuery query);

    public void orWhere(WhereQuery query);

    public String build();

}
