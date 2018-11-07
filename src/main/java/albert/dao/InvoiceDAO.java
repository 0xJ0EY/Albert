package albert.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import albert.models.Amount;
import albert.models.Contact;
import albert.models.Invoice;
import albert.models.Project;
import database.Database;


public class InvoiceDAO implements DAO<Invoice>{
    private Invoice invoice;
    private AmountDAO daoAmount = new AmountDAO();
    private TaxDAO daoTax = new TaxDAO();
    private ProjectDAO projectDAO = new ProjectDAO();

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

            if(rs.next())
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

        String sql = "INSERT INTO \"public\".\"invoice\" (" +
                "\"invoice_id\", " +
                "\"paid\", " +
                "\"tax_id\", " +
                "\"project_id\", " +
                "\"created_at\" " +
                "\"amount_id\", " +
                "\"deliverydate\", " +
                "\"description\" " +
                ") VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            int i = 0;

            statement.setBoolean(++i,this.invoice.getPaid());
            statement.setInt(++i, this.invoice.getTax().getId());
            statement.setInt(++i, this.invoice.getProject().getId());
            statement.setTimestamp(++i, this.invoice.getCreated_at());
            statement.setInt(++i, this.invoice.getAmount().getId());
            statement.setTimestamp(++i, this.invoice.getDeliveryDate());
            statement.setString(++i, this.invoice.getDescription());

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
        String sql = "UPDATE invoice SET  paid=? ,tax_id=?,project_id=?, amount_id=? , deliverydate=?, description=? WHERE invoice_id =?;";


        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            int i = 0;
            statement.setBoolean(++i,this.invoice.getPaid());
            statement.setInt(++i, this.invoice.getTax().getId());
            statement.setInt(++i, this.invoice.getProject().getId());
            statement.setInt(++i,this.invoice.getAmount().getId());
            statement.setTimestamp(++i, this.invoice.getDeliveryDate());
            statement.setString(++i, this.invoice.getDescription());
            statement.setInt(++i,this.invoice.getId());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        daoAmount.update(invoice.getAmount());
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

        Amount amount = daoAmount.loadById(rs.getInt("amount_id"));

        Invoice invoice = new Invoice();
        invoice.setPaid(rs.getBoolean("paid"));
        invoice.setId(rs.getInt("invoice_id"));
        invoice.setProject(projectDAO.loadById(rs.getInt("project_id")));
        invoice.setDeliveryDate(rs.getTimestamp("deliverydate"));
        invoice.setAmount(daoAmount.loadById(rs.getInt("amount_id")));
        invoice.setDeliveryDate(rs.getTimestamp("deliverydate"));
        invoice.setTax(daoTax.loadById(rs.getInt("tax_id")));
        invoice.setId(rs.getInt("invoice_id"));
        invoice.setCreated_at(rs.getTimestamp("created_at"));
        invoice.setDescription(rs.getString("description"));
        return invoice;
    }


}
