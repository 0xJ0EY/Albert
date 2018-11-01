package albert.dao;
import albert.models.Amount;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AmountDAO implements DAO {
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
    public Object loadById(long id) {
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
    public void create(Object obj) {

        this.amount= amount;
        //TODO sql insert schrijven
        String sql = "INSERT INTO amount VALUES (amount_id=?, hours =?, amount=?);";

        try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);

                statement.execute();
                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact added");
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
