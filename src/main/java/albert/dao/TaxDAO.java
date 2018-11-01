package albert.dao;

import albert.models.Tax;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaxDAO implements DAO<Tax> {

    private Tax tax;

    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM customer";
        ArrayList<Tax> contactArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                this.tax = extractFromResultSet(rs);
                contactArrayList.add(tax);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactArrayList;
    }

    @Override
    public Object loadById(long id) {

    }

    @Override
    public void create(Tax obj) {

    }

    @Override
    public void update(Tax obj) {
        this.tax = obj;
        //TODO sql update schrijven
        String sql = "UPDATE tax SET paid=? , amount =? ,deliverydate=?, created_at=? WHERE invoice_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);


            statement.setBoolean(1,this.invoice.getPaid());
            statement.setString(2 ,this.invoice.getAmount());
            statement.setTimestamp(3, this.invoice.getDeliveryDate());
            statement.setInt(4,this.invoice.getId());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Invoice Updated");
    }


    @Override
    public void delete(Tax obj) {
        this.tax = obj;
        //TODO sql delete schrijven
        String sql = "DELETE FROM tax WHERE tax_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, this.tax.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Tax deleted");

    }

    @Override
    public Tax extractFromResultSet(ResultSet rs) throws SQLException {
        return null;

    }
}
