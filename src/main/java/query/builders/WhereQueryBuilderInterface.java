package query.builders;

import query.WhereQuery;

public interface WhereQueryBuilderInterface extends QueryBuilderInterface {

    public void where(String key, String operator);

    public void orWhere(String key, String operator);

    public void where(WhereQuery query);

    public void orWhere(WhereQuery query);

    public void clearWhere();

}
