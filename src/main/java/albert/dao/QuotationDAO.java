package albert.dao;

import albert.models.Quotation;
import database.Database;


import java.sql.*;
import java.util.ArrayList;

public class QuotationDAO implements DAO<Quotation>{

    private Quotation quotation;
    private AmountDAO amountDAO = new AmountDAO();
    @Override
    public ArrayList getAll() {

        String sql = "SELECT * FROM quotation";
        ArrayList<Quotation> quotationArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                this.quotation = extractFromResultSet(rs);
                quotationArrayList.add(quotation);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quotationArrayList;
    }

    @Override
    public Quotation loadById(long id) {
        String sql = "SELECT * FROM quotation WHERE quotation_id= ?";
        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();

            quotation= this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return quotation;
    }



    @Override
    public void create(Quotation quotation) {
        this.quotation = quotation;
        //TODO sql insert schrijven
        String sql = "INSERT INTO quotation(name, description,product, price_expected, created_at, project_id, hours_expected) VALUES (?,?,?,?,?,?,?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);


            statement.setString(1,this.quotation.getName());
            statement.setString(2, this.quotation.getDescription());
            statement.setString(3,  this.quotation.getProduct());
            statement.setInt(4,this.quotation.getExpectedPrice());
            statement.setTimestamp(5,this.quotation.getCreated_at());
            statement.setInt(6,this.quotation.getProject().getId());
            statement.setInt(7,this.quotation.getExpectedHours());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Quotation added");


    }

    @Override
    public void update(Quotation quotation) {
        this.quotation = quotation;
        //TODO sql update schrijven
        String sql = "UPDATE quotation SET ( name = ? ,description =?, product=?, price_expected=?,created_at=?, project_id=?, hours_expected=?)WHERE quotation_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.quotation.getName());
            statement.setString(2, this.quotation.getDescription());
            statement.setString(3,  this.quotation.getProduct());
            statement.setInt(4,this.quotation.getExpectedPrice());
            statement.setTimestamp(5,this.quotation.getCreated_at());
            statement.setInt(6,this.quotation.getProject().getId());
            statement.setInt(7,this.quotation.getExpectedHours());
            statement.setInt(8,this.quotation.getId());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Quotation Updated");
    }

    @Override
    public void delete(Quotation quotation) {
        this.quotation = quotation;
        //TODO sql delete schrijven
        String sql = "DELETE FROM quotation WHERE quotation_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.quotation.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Quotation deleted");
    }

    @Override
    public Quotation extractFromResultSet(ResultSet rs) throws SQLException {
        Quotation quotation = new Quotation(
                rs.getString("name"),
                rs.getString("product"),
                rs.getString("description"),
                rs.getTimestamp("created_at")
        );
        quotation.setExpectedHours(rs.getInt("hours_expected"));
        quotation.setExpectedPrice(rs.getInt("price_expected"));


        return quotation;
    }
}
