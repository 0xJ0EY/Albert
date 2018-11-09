package query;

import database.Database;
import query.builders.QueryBuilder;
import query.exceptions.DatabaseException;
import query.selects.Select;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Class Query.
 *
 */
public class Query implements Cloneable, Serializable {

    /** The values. */
    private ArrayList<Object> values = new ArrayList<>();
    
    /** The query builder. */
    private QueryBuilder queryBuilder;

    /**
     * Table.
     *
     * @param table the table
     * @return the query
     */
    public static Query table(String table) {
        return new Query(table);
    }

    /**
     * Instantiates a new query.
     *
     * @param table the table
     */
    private Query(String table) {
        this.queryBuilder = new QueryBuilder();
        this.queryBuilder.table(table);
    }

    /**
     * Select.
     *
     * @param key the key
     * @return the query
     */
    public Query select(String key) {
        this.queryBuilder.select(key);
        return this;
    }

    /**
     * Clear select.
     *
     * @return the query
     */
    public Query clearSelect() {
        this.queryBuilder.clearSelect();
        return this;
    }

    /**
     * Where.
     *
     * @param key the key
     * @param operator the operator
     * @param value the value
     * @return the query
     */
    public Query where(String key, String operator, Object value) {
        this.queryBuilder.where(key, operator);
        this.values.add(value);
        return this;
    }

    /**
     * Or where.
     *
     * @param key the key
     * @param operator the operator
     * @param value the value
     * @return the query
     */
    public Query orWhere(String key, String operator, Object value) {
        this.queryBuilder.orWhere(key, operator);
        this.values.add(value);
        return this;
    }

    /**
     * Where.
     *
     * @param query the query
     * @return the query
     */
    public Query where(WhereQueryLambda query) {
        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.where(q);

        this.values.addAll(q.getValues());

        return this;
    }

    /**
     * Or where.
     *
     * @param query the query
     * @return the query
     */
    public Query orWhere(WhereQueryLambda query) {
        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.orWhere(q);

        this.values.addAll(q.getValues());

        return this;
    }

    /**
     * Clear where.
     *
     * @return the query
     */
    public Query clearWhere() {
        this.queryBuilder.clearWhere();
        return this;
    }

    /**
     * Join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     * @return the query
     */
    public Query join(String table, String key, String operator, String value) {
        this.queryBuilder.join(table, key, operator, value);
        return this;
    }

    /**
     * Left join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     * @return the query
     */
    public Query leftJoin(String table, String key, String operator, String value) {
        this.queryBuilder.join(table, key, operator, value);
        return this;
    }

    /**
     * Right join.
     *
     * @param table the table
     * @param key the key
     * @param operator the operator
     * @param value the value
     * @return the query
     */
    public Query rightJoin(String table, String key, String operator, String value) {
        this.queryBuilder.join(table, key, operator, value);
        return this;
    }

    /**
     * Group by.
     *
     * @param value the value
     * @return the query
     */
    public Query groupBy(String value) {
        this.queryBuilder.groupBy(value);
        return this;
    }

    /**
     * Order by.
     *
     * @param value the value
     * @param direction the direction
     * @return the query
     */
    public Query orderBy(String value, String direction) {
        this.queryBuilder.orderBy(value, direction);
        return this;
    }

    /**
     * Clear order by.
     *
     * @return the query
     */
    public Query clearOrderBy() {
        this.queryBuilder.clearOrderBy();
        return this;
    }

    /**
     * Limit.
     *
     * @param limit the limit
     * @return the query
     */
    public Query limit(int limit) {

        this.queryBuilder.limit(limit);

        return this;
    }

    /**
     * Clear limit.
     *
     * @return the query
     */
    public Query clearLimit() {

        this.queryBuilder.clearLimit();

        return this;
    }

    /**
     * Offset.
     *
     * @param offset the offset
     * @return the query
     */
    public Query offset(int offset) {
        this.queryBuilder.offset(offset);

        return this;
    }

    /**
     * Clear offset.
     *
     * @return the query
     */
    public Query clearOffset() {
        this.queryBuilder.clearOffset();

        return this;
    }

    /**
     * Gets the values.
     *
     * @return the values
     */
    public ArrayList<Object> getValues() {
        return this.values;
    }

    /**
     * Creates the query.
     *
     * @return the string
     */
    public String createQuery() {
        return this.queryBuilder.build();
    }

    /**
     * Fetch.
     *
     * @return the array list
     */
    public ArrayList<Record> fetch() {

        ArrayList<Record> records = null;

        try {
            // Setup the database connection and execute query
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.createQuery());

            // Fetch the results and fit them into the records
            ResultSet rs = this.executeQuery(conn, statement);

            records = this.createRecords(rs);

            // Close the connections
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }

        return records;
    }

    /**
     * Execute query.
     *
     * @param conn the conn
     * @param statement the statement
     * @return the result set
     * @throws SQLException the SQL exception
     */
    private ResultSet executeQuery(Connection conn, PreparedStatement statement) throws SQLException {

        // Bind the params to the query
        for (int i = 0; i < this.values.size(); i++) {
            statement.setObject(i + 1, this.values.get(i));
        }

        return statement.executeQuery();
    }

    /**
     * Creates the records.
     *
     * @param rs the rs
     * @return the array list
     * @throws SQLException the SQL exception
     */
    private ArrayList<Record> createRecords(ResultSet rs) throws SQLException {
        if (rs == null)
            return new ArrayList<>();

        ArrayList<Select> selected = this.queryBuilder.getSelected();

        int dataLength = this.queryBuilder.getSelected().size();

        ArrayList<Record> records = new ArrayList<>();
        HashMap<String, Object> objects;

        while (rs.next()) {

            objects = new HashMap<>();

            for (int i = 0; i < dataLength; i++) {
                objects.put(
                    selected.get(i).getKey(),
                    rs.getObject(i + 1
                ));
            }

            records.add(new Record(objects));
        }

        return records;
    }
}
