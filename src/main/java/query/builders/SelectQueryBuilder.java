package query.builders;

import query.selects.Select;

import java.util.ArrayList;

public class SelectQueryBuilder implements SelectQueryBuilderInterface {

    private ArrayList<Select> selects = new ArrayList<>();

    @Override
    public void select(String key) {
        this.selects.add(new Select(key));
    }

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

    @Override
    public ArrayList<Select> getSelected() {
        return this.selects;
    }

    @Override
    public void clearSelect() {
        this.selects = new ArrayList<>();
    }
}
