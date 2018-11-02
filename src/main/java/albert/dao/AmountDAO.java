package albert.dao;
import albert.models.Amount;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AmountDAO implements DAO<Amount> {
    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM amount";
        ArrayList<Amount> AmountArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Amount amount = (Amount) extractFromResultSet(rs);
                AmountArrayList.add(amount);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AmountArrayList;
    }

    @Override
    public Amount loadById(long id) {
         Amount amount = null;

        String sql = "SELECT * FROM amount WHERE amount_id = ?";

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

        return amount;
    }

    private Amount amount;
    @Override
    public void create(Amount obj) {

        this.amount= obj;
        //TODO sql insert schrijven
        String sql = "INSERT INTO amount VALUES (amount_id=?, hours =?, price=?,contact_id=?);";

        try {
                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1,this.amount.getId());
                statement.setDouble(2,this.amount.getHours());
                statement.setDouble(3,this.amount.getPrice());
                statement.setString(4,this.amount.getContact());

                statement.execute();

                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Amount added");
    }

    @Override
    public void update(Amount obj) {
        this.amount = obj;
        //TODO sql update schrijven
        String sql = "UPDATE amount SET( hours=?, price =?, contact_id=? ) WHERE amount_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1,this.amount.getHours());
            statement.setDouble(2,this.amount.getPrice());
            statement.setString(3, this.amount.getContact());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("amount Updated");

    }

    @Override
    public void delete(Amount obj) {
        this.amount = obj;
        //TODO sql delete schrijven
        String sql = "DELETE FROM amount WHERE amount_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.amount.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Amount deleted");
    }

    @Override
    public Object extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}