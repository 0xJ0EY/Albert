package query.builders;

import query.selects.Select;

import java.util.ArrayList;

/**
 * The Interface SelectQueryBuilderInterface.
 *
 */
public interface SelectQueryBuilderInterface extends QueryBuilderInterface {

    /**
     * Select.
     *
     * @param key the key
     */
    public void select(String key);

    /**
     * Gets the selected.
     *
     * @return the selected
     */
    public ArrayList<Select> getSelected();

    /**
     * Clear select.
     */
    public void clearSelect();

}
