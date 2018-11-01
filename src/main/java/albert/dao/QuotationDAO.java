package albert.dao;

import albert.models.Quotation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuotationDAO implements DAO{
    private Quotation quotation;

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public Object loadById(long id) {
        return null;
    }


    @Override
    public void create(Object quotation) {
        //TODO sql insert schrijven
        String sql = "";
        this.quotation = (Quotation) quotation;
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
