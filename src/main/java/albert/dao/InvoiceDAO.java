package albert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import albert.models.Invoice;
import albert.models.Project;
import database.Database;


public class InvoiceDAO implements DAO<Invoice>{
    private Invoice invoice;

    @Override
    public ArrayList<Invoice> getAll() {
        String sql = "SELECT * FROM invoice";
        ArrayList<Invoice> invoiceArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Invoice invoice = extractFromResultSet(rs);
                invoiceArrayList.add(invoice);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoiceArrayList;

    }

    @Override
    public Invoice loadById(long id) {

        String sql = "SELECT * FROM invocie WHERE id = ?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();

            this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return invoice;
    }



    @Override
    public void create(Invoice obj) {
    this.invoice = invoice;
        //TODO sql insert schrijven
        String sql = "INSERT INTO invoice VALUES (invoice_id=?, paid=? ,created_at= ?, amount=?, deliverydate=?);";



        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.invoice.getId());
            statement.setBoolean(2,true);
            statement.setTimestamp(3, null);
            statement.setString(4,null);
            statement.setTime(5,null);

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Invoice added");
    }
    
    @Override
    public void update(Invoice obj) {
        this.invoice = invoice;
        //TODO sql update schrijven
        String sql = "UPDATE invoice SET paid=? , amount =? ,deliverydate=?, created_at=? WHERE invoice_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(4,this.invoice.getId());
            statement.setBoolean(1,true);
            statement.setString(2 ,null);
            statement.setTime(3, null);

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Invoice Updated");

    }

    @Override
    public void delete(Invoice obj) {
        this.invoice = invoice;
        //TODO sql delete schrijven
        String sql = "DELETE FROM invoice WHERE invoice_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.invoice.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Invoice deleted");

    }

    @Override
    public ArrayList<Invoice> extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    public List<Invoice> getByProject(Project project) {
        return null;
    }
}
