package albert.dao;

import albert.models.Rapportage;
import database.Database;

import java.sql.*;
import java.util.ArrayList;
//NAKIJKEN
public class RapportDAO implements DAO<Rapportage> {

    private Rapportage rapportage;
    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM report";
        ArrayList<Rapportage> reportArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                rapportage =  extractFromResultSet(rs);
                reportArrayList.add(rapportage);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportArrayList;
    }

    private Rapportage report;
    @Override
    public Rapportage loadById(long id) {
        String sql = "SELECT * FROM report WHERE report_id= ?";
        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();

            rapportage = this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return report;
    }

    @Override
    public void create(Rapportage obj) {
        this.report = report;
        //TODO sql insert schrijven
        String sql = "INSERT INTO report VALUES (report_id=?, naam=? , end_date =?, start_date=?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.report.getId());
            statement.setString(2,this.report.getName());
            statement.setTimestamp(3, this.report.getStartDate());
            statement.setTimestamp(4, this.report.getEndDate());


            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Report added");

    }

    @Override
    public void update(Rapportage report) {
        this.report = report;
        //TODO sql update schrijven
        String sql = "UPDATE report SET ( naam=? , end_date =?, start_date=? )WHERE report_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.report.getName());
            statement.setTimestamp(2,this.report.getEndDate());
            statement.setTimestamp(3,this.report.getStartDate());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Report Updated");
    }

    @Override
    public void delete(Rapportage obj) {
        this.report = report;
        //TODO sql delete schrijven
        String sql = "DELETE FROM report WHERE report_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.report.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("report deleted");
    }

    @Override
    public Rapportage extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
