package query.builders;

import query.selects.Select;

import java.util.ArrayList;

public interface SelectQueryBuilderInterface extends QueryBuilderInterface {

    public void select(String key, Object type);

    public ArrayList<Select> getSelected();

    public void clearSelect();

}
