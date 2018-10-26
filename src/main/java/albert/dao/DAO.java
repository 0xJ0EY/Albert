package albert.dao;

import albert.models.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {

    public ArrayList<T> getAll();

    public T loadById(long id);

    public void create(T obj);

    public void update(T obj);

    public void delete(T obj);

    // Extract the results to an object
    public T extractFromResultSet(ResultSet rs) throws SQLException;

}
