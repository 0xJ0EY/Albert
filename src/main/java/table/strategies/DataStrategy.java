package table.strategies;

import table.Table;

public interface DataStrategy {

    public int getMaxPage();

    public int getPage();

    public int getLimit();

    public void setPage(int page);

    public void setTable(Table table);

    public void setLimit(int limit);

    public Table getTable();

    public void fetch();

    public void orderBy(String column, String direction);

    public void search(String str);

}
