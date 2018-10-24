package table.strategies;

import table.Column;
import table.Table;
import table.dao.db.Query;
import table.dao.db.Record;
import table.enumerations.OrderBy;

import java.util.ArrayList;

public class DatabaseStrategy implements DataStrategy {

    private Query originalBaseQuery;
    private Query baseQuery;

    private Table table;

    private int offset = 0;
    private int limit = -1;

    public DatabaseStrategy(Query query) {
        this.baseQuery = query;
        this.originalBaseQuery = query;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void resetOffset() {
        this.offset = 0;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public Table getTable() {
        return this.table;
    }

    @Override
    public void fetch() {

        this.fetchRows();

        this.totalRows();

        this.currentRows();

    }

    private void fetchRows() {
        Query searchQuery = this.baseQuery;

        // Set limit and offset
        searchQuery
            .clearSelect()
            .limit(this.limit)
            .offset(this.offset)
        ;

        // Build select statements
        ArrayList<Column> columns = this.table.getCols();

        for (Column column : columns) {
            searchQuery.select(column.getDatabaseColumn(), String.class);
        }

        ArrayList<Record> records = searchQuery.fetch();

        for (Record record : records) {
            this.table.addRow(record.getObjects().toArray());
        }
    }

    public void totalRows() {

        Query countQuery = this.baseQuery;

        countQuery
            .clearSelect()
            .clearLimit()
            .clearOffset()
        ;

        countQuery.select("COUNT(*)", Integer.class);

        Record record = countQuery.fetch().get(0);

        this.table.setTotalRows(((Long) record.getObjects().get(0)).intValue());
    }

    public void currentRows() {

        // Just set the current loaded records
        this.table.setCurrentRows(this.table.getData().size());

    }

    @Override
    public void orderBy(Column column, OrderBy orderBy) {

    }

    @Override
    public void search(String str) {
        if (str.length() == 0) {
            this.baseQuery = this.originalBaseQuery;

            return;
        }

        // Loop through columns


    }
}
