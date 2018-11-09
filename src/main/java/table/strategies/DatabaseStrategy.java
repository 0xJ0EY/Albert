package table.strategies;

import config.Config;
import org.apache.commons.lang.SerializationUtils;
import query.orderby.OrderBy;
import table.Column;
import table.Table;
import query.Query;
import query.Record;

import java.util.ArrayList;
import java.util.HashSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseStrategy.
 * @author
 */
public class DatabaseStrategy implements DataStrategy {

    /** The original base query. */
    private final Query originalBaseQuery;
    
    /** The base query. */
    private Query baseQuery;

    /** The table. */
    private Table table;

    /** The order by. */
    private ArrayList<OrderBy> orderBy = new ArrayList<>();

    /** The page. */
    private int page = 1;
    
    /** The total. */
    private int total = 0;

    /** The offset. */
    private int offset = 0;
    
    /** The limit. */
    private int limit = Integer.parseInt(Config.get("table", "settings.default_rows"));

    /**
     * Instantiates a new database strategy.
     *
     * @param query the query
     */
    public DatabaseStrategy(Query query) {
        this.baseQuery = (Query) SerializationUtils.clone(query);
        this.originalBaseQuery = (Query) SerializationUtils.clone(query);
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#getMaxPage()
     */
    @Override
    public int getMaxPage() {
        return (int) Math.ceil((double) this.total / this.limit);
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#getPage()
     */
    @Override
    public int getPage() {
        return this.page;
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#setPage(int)
     */
    @Override
    public void setPage(int page) {
        page = Math.max(1, page);

        this.page = page;
        this.offset = (page - 1) * limit;
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#setTable(table.Table)
     */
    public void setTable(Table table) {
        this.table = table;
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#getTable()
     */
    @Override
    public Table getTable() {
        return this.table;
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#fetch()
     */
    @Override
    public void fetch() {

        this.fetchRows();

        this.totalRows();

        this.currentRows();

        this.table.loaded();

        this.table.update();

    }

    /**
     * Fetch rows.
     */
    private void fetchRows() {
        Query searchQuery = this.baseQuery;

        // Set setLimit and offset
        searchQuery
            .clearSelect()
            .limit(this.limit)
            .offset(this.offset)
            .clearOrderBy()
        ;

        // Build select statements
        ArrayList<Column> columns = this.table.getCols();

        for (OrderBy orderBy: this.orderBy) {
            searchQuery.orderBy(orderBy.getName(), orderBy.getDirection());
        }

        HashSet<String> cols = new HashSet<>();

        for (Column column : columns) {
            cols.addAll(column.getRequiredDatabaseColumns());
        }

        for (String col : cols) {
            searchQuery.select(col);
        }

        ArrayList<Record> records = searchQuery.fetch();

        for (Record record : records) {
            this.table.addRow(record.getValues());
        }
    }

    /**
     * Total rows.
     */
    public void totalRows() {

        Query countQuery = this.baseQuery;

        countQuery
            .clearSelect()
            .clearLimit()
            .clearOffset()
            .clearOrderBy()
        ;

        countQuery.select("COUNT(*)");

        Record record = countQuery.fetch().get(0);

        this.total = ((Long) record.getObjects().get(0)).intValue();
        this.table.setTotalRows(this.total);
    }

    /**
     * Current rows.
     */
    public void currentRows() {

        // Just set the current loaded records
        this.table.setCurrentRows(this.table.getData().size());

    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#orderBy(java.lang.String, java.lang.String)
     */
    @Override
    public void orderBy(String table, String direction) {
        this.orderBy.add(new OrderBy(table, direction));
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#search(java.lang.String)
     */
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

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#setLimit(int)
     */
    @Override
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /* (non-Javadoc)
     * @see table.strategies.DataStrategy#getLimit()
     */
    @Override
    public int getLimit() {
        return this.limit;
    }
}
