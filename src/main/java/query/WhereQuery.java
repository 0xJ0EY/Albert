package query;

import java.io.Serializable;
import java.util.ArrayList;

public interface WhereQuery extends Serializable {

    public WhereQuery where(String key, String operator, Object value);

    public WhereQuery orWhere(String key, String operator, Object value);

    public WhereQuery where(WhereQueryLambda query);

    public WhereQuery orWhere(WhereQueryLambda query);

    public ArrayList<Object> getValues();

    public String createQuery();

}
