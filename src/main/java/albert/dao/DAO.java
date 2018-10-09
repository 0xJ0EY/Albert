package albert.dao;

import java.util.ArrayList;

public interface DAO<T> {

    public ArrayList<T> getAll();

    public T loadById(long id);

    public void create(T obj);

    public void update(T obj);

    public void delete(T obj);

}
