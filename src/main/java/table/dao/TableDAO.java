package table.dao;

import table.Row;

import java.util.ArrayList;

public interface TableDAO {

    public void setOffset(int offset);

    public int count();

    public ArrayList<Row> fetch(int limit);

}
