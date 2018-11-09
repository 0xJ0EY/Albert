package query.builders;

import query.selects.Select;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectQueryBuilder.
 * @author
 */
public class SelectQueryBuilder implements SelectQueryBuilderInterface {

    /** The selects. */
    private ArrayList<Select> selects = new ArrayList<>();

    /* (non-Javadoc)
     * @see query.builders.SelectQueryBuilderInterface#select(java.lang.String)
     */
    @Override
    public void select(String key) {
        this.selects.add(new Select(key));
    }

    /* (non-Javadoc)
     * @see query.builders.QueryBuilderInterface#build()
     */
    @Override
    public String build() {

        // If no selects are given, take all columns from the database table
        if (this.selects.size() == 0)
            return "SELECT *";

        ArrayList<String> names = new ArrayList<>();

        for (Select select : this.selects) {
            names.add(select.getKey());
        }

        return "SELECT " + String.join(", ", names);
    }

    /* (non-Javadoc)
     * @see query.builders.SelectQueryBuilderInterface#getSelected()
     */
    @Override
    public ArrayList<Select> getSelected() {
        return this.selects;
    }

    /* (non-Javadoc)
     * @see query.builders.SelectQueryBuilderInterface#clearSelect()
     */
    @Override
    public void clearSelect() {
        this.selects = new ArrayList<>();
    }
}
