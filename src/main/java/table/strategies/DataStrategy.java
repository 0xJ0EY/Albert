package table.strategies;

import table.Column;
import table.Table;
import table.enumerations.OrderBy;

public interface DataStrategy {

    public void setOffset(int offset);

    public void setLimit(int limit);

    public void resetOffset();

    public void setTable(Table table);

    public Table getTable();

    public void fetch();

    public void orderBy(Column column, OrderBy orderBy);

    public void search(String str);

}
