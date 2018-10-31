package albert.dao;

import albert.models.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactDAO implements DAO {
    private Contact contact;

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public Object loadById(long id) {
        return null;
    }


    @Override
    public void create(Object contact) {

        String sql = "";
       this.contact = (Contact) contact;
        System.out.println("Contact added");


    }

    public void update(Object o, String[] params) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public Object extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
