package query.builders;

public class TableQueryBuilder implements TableQueryBuilderInterface {

    private String table;

    public TableQueryBuilder() {
    }

    public TableQueryBuilder(TableQueryBuilder table) {
        this.table = table.table;
    }

    @Override
    public void table(String table) {
        this.table = table;
    }

    @Override
    public String build() {
        return " FROM " + this.table;
    }
}
