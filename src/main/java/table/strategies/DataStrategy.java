package table.strategies;

import table.Column;
import table.Row;
import table.Table;
import table.enumerations.OrderBy;

import java.util.ArrayList;

public interface DataStrategy {

    public int totalRows();

    public int currentRows();

    public void setOffset(int offset);

    public void resetOffset();

    public void setTable(Table table);

    public ArrayList<Row> fetch(int amount);

    public void orderBy(Column column, OrderBy orderBy);

    public void search(String str);

}
