package table.dao.db;

import database.Database;
import table.dao.db.builders.QueryBuilder;
import table.dao.db.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Query {

    private ArrayList<Object> values = new ArrayList<>();
    private QueryBuilder queryBuilder;

    public static Query table(String table) {
        return new Query(table);
    }

    private Query(String table) {
        this.queryBuilder = new QueryBuilder();
        this.queryBuilder.table(table);
    }

    public Query select(String key, Object type) {
        this.queryBuilder.select(key, type);
        return this;
    }

    public Query clearSelect() {
        this.queryBuilder.clearSelect();
        return this;
    }

    public Query where(String key, String operator, Object value) {
        this.queryBuilder.where(key, operator);
        this.values.add(value);
        return this;
    }

    public Query orWhere(String key, String operator, Object value) {
        this.queryBuilder.orWhere(key, operator);
        this.values.add(value);
        return this;
    }

    public Query where(WhereQueryLambda query) {
        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.where(q);

        this.values.addAll(q.getValues());

        return this;
    }

    public Query orWhere(WhereQueryLambda query) {
        WhereDB child = new WhereDB();

        WhereQuery q = query.query(child);
        this.queryBuilder.orWhere(q);

        this.values.addAll(q.getValues());

        return this;
    }

    public Query clearWhere() {
        this.queryBuilder.clearWhere();
        return this;
    }

    public Query limit(int limit) {

        this.queryBuilder.limit(limit);

        return this;
    }

    public Query clearLimit() {

        this.queryBuilder.clearLimit();

        return this;
    }

    public Query offset(int offset) {
        this.queryBuilder.offset(offset);

        return this;
    }

    public Query clearOffset() {
        this.queryBuilder.clearOffset();

        return this;
    }

    public ArrayList<Object> getValues() {
        return this.values;
    }

    public String createQuery() {
        return this.queryBuilder.build();
    }

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

    private ResultSet executeQuery(Connection conn, PreparedStatement statement) throws SQLException {

        // Bind the params to the query
        for (int i = 0; i < this.values.size(); i++) {
            statement.setObject(i + 1, this.values.get(i));
        }

        return statement.executeQuery();
    }

    private ArrayList<Record> createRecords(ResultSet rs) throws SQLException {
        if (rs == null)
            return new ArrayList<>();

        // TODO: Find auto length
        int dataLength = this.queryBuilder.getSelected().size();

        ArrayList<Record> records = new ArrayList<>();
        ArrayList<Object> objects;

        while (rs.next()) {

            objects = new ArrayList<>();

            for (int i = 0; i < dataLength; i++) {
                objects.add(rs.getObject(i + 1));
            }

            records.add(new Record(objects));
        }

        return records;
    }
}
