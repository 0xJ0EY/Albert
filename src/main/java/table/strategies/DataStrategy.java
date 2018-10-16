package table.strategies;

import table.Row;
import table.Table;

import java.util.ArrayList;

public interface DataStrategy {

    public void setTable(Table table);

    public ArrayList<Row> fetch();

}
