package albert.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import albert.models.Invoice;

public class InvoiceDAO implements DAO<Invoice>{
    private Invoice invoice;

    @Override
    public ArrayList<Invoice> getAll() {
        return null;
    }

    @Override
    public Invoice loadById(long id) {
        return null;
    }

    @Override
    public void create(Invoice obj) {
        //TODO sql insert schrijven
        String sql = "";
        this.invoice = (Invoice) obj;
        System.out.println("Contact added");
    }
    
    @Override
    public void update(Invoice obj) {

    }

    @Override
    public void delete(Invoice obj) {

    }

    @Override
    public Invoice extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
