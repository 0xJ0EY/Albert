package albert.dao;

import albert.models.Quotation;
import database.Database;


import java.sql.*;
import java.util.ArrayList;

public class QuotationDAO implements DAO{

    private Quotation quotation;
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
    public Object loadById(long id) {
        String sql = "SELECT * FROM quotation WHERE quotation_id= ?";
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

        return quotation;
    }



    @Override
    public void create(Object quotation) {
        this.quotation = (Quotation) quotation;
        //TODO sql insert schrijven
        String sql = "INSERT INTO quotation VALUES (quotation_id=?, name = ? ,description =?, product=?, amount_id=?,created_at=?, project_id=?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.quotation.getId());
            statement.setString(2,this.quotation.getName());
            statement.setString(3, this.quotation.getDescription());
            statement.setString(4,  this.quotation.getProduct());
            statement.setInt(5,this.quotation.getAmount().getId());
            statement.setTimestamp(6,this.quotation.getCreated_at());
            statement.setInt(7,this.quotation.getProject().getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Quotation added");


    }

    public void update(Object o, String[] params) {

    }

    @Override
    public void update(Object obj) {
        this.quotation = quotation;
        //TODO sql update schrijven
        String sql = "UPDATE quotation SET ( name = ? ,description =?, product=?, amount_id=?,created_at=?, project_id=?)WHERE quotation_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.quotation.getName());
            statement.setString(2, this.quotation.getDescription());
            statement.setString(3,  this.quotation.getProduct());
            statement.setInt(4,this.quotation.getAmount().getId());
            statement.setTimestamp(5,this.quotation.getCreated_at());
            statement.setInt(6,this.quotation.getProject().getId());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Quotation Updated");
    }

    @Override
    public void delete(Object obj) {
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
        return quotation;
    }
}
