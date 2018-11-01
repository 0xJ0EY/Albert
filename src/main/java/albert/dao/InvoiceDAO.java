package albert.dao;

import java.sql.*;
import java.util.ArrayList;
import albert.models.Invoice;
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

        String sql = "SELECT * FROM invocie WHERE invoice_id= ?";
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
        String sql = "INSERT INTO invoice VALUES (invoice_id=?, paid=? ,tax_id= ?,created_at=? , amount=?, deliverydate=?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.invoice.getId());
            statement.setString(2,this.invoice.getPaid());
            statement.setString(3, null);
            statement.setTime(4, (Time) this.invoice.getCreated_at());
            statement.setString(5,null);
            statement.setDate(6, (Date) this.invoice.getDeliveryDate());

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
        String sql = "UPDATE invoice SET paid=? , tax_id=? , created_at = ?, amount =? ,deliverydate=? WHERE invoice_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.invoice.getPaid());
            statement.setString(2,null);
            statement.setTime(3 , (Time) this.invoice.getCreated_at());
            statement.setString(4,null);
            statement.setDate(5, (Date) this.invoice.getDeliveryDate());

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
    public Invoice extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
