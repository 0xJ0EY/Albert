package table.strategies;

import table.Column;
import table.Row;
import table.Table;
import table.dao.TableDAO;
import table.enumerations.OrderBy;

import java.util.ArrayList;

public class DatabaseStrategy implements DataStrategy {

    private TableDAO tableDAO;
    private Table table;

    public DatabaseStrategy(TableDAO tableDAO) {
        this.tableDAO = tableDAO;
    }

    @Override
    public int totalRows() {
        return this.tableDAO.count();
    }

    @Override
    public int currentRows() {
        return this.tableDAO.count();
    }

    @Override
    public void setOffset(int offset) {
        this.tableDAO.setOffset(offset);
    }

    @Override
    public void resetOffset() {
        this.tableDAO.setOffset(0);
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public ArrayList<Row> fetch(int amount) {
        return this.tableDAO.fetch(amount);
    }

    @Override
    public void orderBy(Column column, OrderBy orderBy) {

    }

    @Override
    public void search(String str) {

    }
}
