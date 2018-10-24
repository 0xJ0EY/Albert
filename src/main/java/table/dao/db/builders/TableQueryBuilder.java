package table.dao.db.builders;

public class TableQueryBuilder implements TableQueryBuilderInterface {

    private String table;

    @Override
    public void table(String table) {
        this.table = table;
    }

    @Override
    public String build() {
        return " FROM " + this.table;
    }
}
