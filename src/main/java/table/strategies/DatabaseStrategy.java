package table.strategies;

import table.Row;
import table.Table;

import java.util.ArrayList;

public class DatabaseStrategy implements DataStrategy {

    private Table table;

    @Override
    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public ArrayList<Row> fetch() {
        return new ArrayList<>();
    }
}
