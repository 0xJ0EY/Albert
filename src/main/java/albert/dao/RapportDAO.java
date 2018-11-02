package albert.dao;

import albert.models.Rapportage;
import database.Database;

import java.sql.*;
import java.util.ArrayList;

public class RapportDAO implements DAO {
    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM report";
        ArrayList<Rapportage> reportArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Rapportage report = (Rapportage) extractFromResultSet(rs);
                reportArrayList.add(report);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportArrayList;
    }

    private Rapportage report;
    @Override
    public Object loadById(long id) {
        String sql = "SELECT * FROM report WHERE report_id= ?";
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

        return report;
    }

    @Override
    public void create(Object obj) {
        this.report = report;
        //TODO sql insert schrijven
        String sql = "INSERT INTO report VALUES (report_id=?, naam=? , end_date =?, start_date=?);";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.report.getId());
            statement.setString(2,this.report.getName());
            statement.setDate(3, (Date) this.report.getStartDate());
            statement.setDate(4, (Date) this.report.getEndDate());


            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Report added");

    }

    @Override
    public void update(Object obj) {
        this.report = report;
        //TODO sql update schrijven
        String sql = "UPDATE report SET ( naam=? , end_date =?, start_date=? )WHERE report_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.report.getName());
            statement.setDate(2,(Date) this.report.getEndDate());
            statement.setDate(3,(Date) this.report.getStartDate());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Report Updated");
    }

    @Override
    public void delete(Object obj) {
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
    public Object extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
