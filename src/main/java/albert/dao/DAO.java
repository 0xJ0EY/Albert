package albert.dao;

import albert.models.Invoice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Interface for standard mehtods for an dao.
 * @author
 * @param <T> the generic type
 */
public interface DAO<T> {

    /**
     * Gets the all.
     *
     * @return the all
     */
    public ArrayList<T> getAll();

    /**
     * Load by id.
     *
     * @param id the id
     * @return the t
     */
    public T loadById(long id);

    /**
     * Creates the.
     *
     * @param obj the obj
     */
    public void create(T obj);

    /**
     * Update.
     *
     * @param obj the obj
     */
    public void update(T obj);

    /**
     * Delete.
     *
     * @param obj the obj
     */
    public void delete(T obj);

    /**
     * Extract from result set.
     *
     * @param rs the rs
     * @return the object
     * @throws SQLException the SQL exception
     */
    // Extract the results to an object
    public Object extractFromResultSet(ResultSet rs) throws SQLException;

}
