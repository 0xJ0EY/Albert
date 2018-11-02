package albert.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import albert.models.Contact;
import albert.models.Invoice;
import albert.models.Project;
import database.Database;


public class InvoiceDAO implements DAO<Invoice>{
    private Invoice invoice;
    private AmountDAO daoAmount = new AmountDAO();
    private TaxDAO daoTax = new TaxDAO();
    private ProjectDAO daoProject = new ProjectDAO();


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

        String sql = "SELECT * FROM invoice WHERE invoice_id = ?";

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();

            invoice = this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return invoice;
    }



    @Override
    public void create(Invoice obj) {
    this.invoice = obj;
        //TODO sql insert schrijven
        String sql = "INSERT INTO invoice VALUES (invoice_id=?, paid=? ,tax_id= ?,project_id=?, amount_id ,created_at=? , deliverydate=?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.invoice.getId());

            statement.setString(2,this.invoice.getPaid());
            statement.setInt(3, this.invoice.getTax().getId());
            statement.setInt(4,  this.invoice.getProject().getId());
            statement.setInt(5,this.invoice.getAmount().getId());
            statement.setTime(6,(Time) this.invoice.getCreated_at());
            statement.setTimestamp(7, this.invoice.getDeliveryDate());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Invoice added");
    }
    
    @Override
    public void update(Invoice obj) {
        this.invoice = obj;
        //TODO sql update schrijven
        String sql = "UPDATE invoice SET ( paid=? ,tax_id= ?,project_id=?, amount_id=? ,created_at=? , deliverydate=?)WHERE invoice_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);


            statement.setString(1,this.invoice.getPaid());
            statement.setInt(2, this.invoice.getTax().getId());
            statement.setInt(3, this.invoice.getProject().getId());
            statement.setInt(4 ,this.invoice.getAmount().getId());
            statement.setTimestamp(4, this.invoice.getDeliveryDate());
            statement.setInt(4,this.invoice.getId());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Invoice Updated");

    }

    @Override
    public void delete(Invoice obj) {
        this.invoice = obj;
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
        Invoice invoice = new Invoice();
        invoice.setPaid(rs.getString("paid"));
        invoice.setDeliveryDate(rs.getTimestamp("deliverydate"));
        invoice.setAmount(daoAmount.loadById(rs.getInt("amount_id")));
        invoice.setDeliveryDate(rs.getTimestamp("deliverydate"));
        invoice.setTax(daoTax.loadById(rs.getInt("tax_id")));
        invoice.setProject(daoProject.loadById(rs.getInt("project_id")));
        return invoice;
    }


}
