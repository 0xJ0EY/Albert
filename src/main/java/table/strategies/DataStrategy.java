package table.strategies;

import table.Column;
import table.Table;
import table.enumerations.OrderBy;

public interface DataStrategy {

    public int getMaxPage();

    public int getPage();

    public void setPage(int page);

    public void setTable(Table table);

    public Table getTable();

    public void fetch();

    public void orderBy(Column column, OrderBy orderBy);

    public void search(String str);

}
