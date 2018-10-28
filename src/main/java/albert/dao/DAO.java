package albert.dao;

import java.util.ArrayList;

/*
Dit DAO klas zorgt voor het omgaan met de data, zodat de gebruiker create, update, delete ,load kan deon.
 */
public interface DAO<T> {

    public ArrayList<T> getAll();

    public T loadById(long id);

    public void create(T obj);

    public void update(T obj);

    public void delete(T obj);

}
