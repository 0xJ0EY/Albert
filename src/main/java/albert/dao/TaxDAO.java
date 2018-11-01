package albert.dao;

import albert.models.Amount;
import albert.models.Tax;
import database.Database;

import java.sql.*;
import java.util.ArrayList;

public class TaxDAO implements DAO {
    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM tax";
        ArrayList<Tax> taxArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Tax tax = (Tax) extractFromResultSet(rs);
                taxArrayList.add(tax);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxArrayList;
    }

    private Tax tax;
    @Override
    public Object loadById(long id) {
        String sql = "SELECT * FROM tax WHERE tax_id= ?";
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

        return tax;
    }

    @Override
    public void create(Object obj) {
        this.tax = tax;
        //TODO sql insert schrijven
        String sql = "INSERT INTO tax VALUES (tax_id=?, name=?, percentage=?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.tax.getId());
            statement.setString(2,this.tax.getName());
            statement.setInt(3,this.tax.getPercentage());


            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Tax added");
    }

    @Override
    public void update(Object obj) {
        this.tax = tax;
        //TODO sql update schrijven
        String sql = "UPDATE tax SET ( name=?, percentage=? )WHERE tax_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.tax.getName());
            statement.setInt(2,this.tax.getPercentage());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("tax Updated");
    }

    @Override
    public void delete(Object obj) {
        this.tax = tax;
        //TODO sql delete schrijven
        String sql = "DELETE FROM tax WHERE tax_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.tax.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Tax deleted");
    }

    @Override
    public Object extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
