package table.dao.db;

import java.util.ArrayList;

public interface WhereQuery {

    public WhereQuery where(String key, String operator, Object value);

    public WhereQuery orWhere(String key, String operator, Object value);

    public WhereQuery where(WhereQueryLambda query);

    public WhereQuery orWhere(WhereQueryLambda query);

    public ArrayList<Object> getValues();

    public String createQuery();

}
