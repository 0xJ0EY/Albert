package table.strategies;

import config.Config;
import org.apache.commons.lang.SerializationUtils;
import table.Column;
import table.Table;
import query.Query;
import query.Record;
import table.enumerations.OrderBy;

import java.util.ArrayList;

public class DatabaseStrategy implements DataStrategy {

    private final Query originalBaseQuery;
    private Query baseQuery;

    private Table table;

    private int page;
    private int total = 0;

    private int offset = 0;
    private int limit = Integer.parseInt(Config.get("database", "settings.default_rows"));

    public DatabaseStrategy(Query query) {
        this.baseQuery = (Query) SerializationUtils.clone(query);
        this.originalBaseQuery = (Query) SerializationUtils.clone(query);
    }

    @Override
    public int getMaxPage() {
        return (int) Math.ceil((double) this.total / this.limit);
    }

    @Override
    public void setPage(int page) {
        page = Math.max(1, page);

        this.page = page;
        this.offset = (page - 1) * limit;
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

        this.total = ((Long) record.getObjects().get(0)).intValue();
        this.table.setTotalRows(this.total);
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

        this.baseQuery = (Query) SerializationUtils.clone(this.originalBaseQuery);

        // Build filters
        ArrayList<Column> columns = this.table.getCols();

        this.baseQuery.where(query -> {
            for (Column column : columns) {
                query.orWhere(column.getDatabaseColumn(), "ilike", "%" + str + "%");
            }

            return query;
        });

    }
}