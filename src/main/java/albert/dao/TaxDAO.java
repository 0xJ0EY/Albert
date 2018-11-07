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
    public ArrayList<Tax> getAll() {
        String sql = "SELECT * FROM tax";
        ArrayList<Tax> taxArrayList = null;

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){

                Tax tax = this.extractFromResultSet(rs);

                taxArrayList.add(tax);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taxArrayList;
    }


    @Override
    public Tax loadById(long id) {
        String sql = "SELECT * FROM tax WHERE tax_id= ?";
        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();

            tax = this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tax;
    }

    @Override
    public void create(Tax obj) {
        this.tax = tax;
        //TODO sql insert schrijven
        String sql = "INSERT INTO tax(name, percentage) VALUES(?,?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.tax.getName());
            statement.setInt(2,this.tax.getPercentage());


            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Tax added");
    }

    @Override
    public void update(Tax tax) {
        this.tax = tax;
        //TODO sql update schrijven
        String sql = "UPDATE tax SET  name=?, percentage=? WHERE tax_id =?";


        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);


            statement.setString(1,this.tax.getName());
            statement.setInt(2,this.tax.getPercentage());
            statement.setInt(3,this.tax.getId());



            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("tax Updated");
    }

    @Override
    public void delete(Tax obj) {

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

    }

    @Override
    public Tax extractFromResultSet(ResultSet rs) throws SQLException {
        Tax tax = new Tax();

        tax.setId(rs.getInt("tax_id"));
        tax.setName(rs.getString("name"));
        tax.setPercentage(rs.getInt("percentage"));

        return tax;
    }

}
