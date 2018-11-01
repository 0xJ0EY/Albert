package albert.dao;

import albert.models.Invoice;
import albert.models.Project;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProjectDAO implements DAO<Project> {


    @Override
    public ArrayList<Project> getAll() {

        String sql = "SELECT * FROM project";
        ArrayList<Project> projectArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Project project = extractFromResultSet(rs);
                projectArrayList.add(project);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectArrayList;
    }

        @Override
    public Project loadById(long id) {
        Project project = null;

        String sql = "SELECT * FROM project WHERE project_id = ?";

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

        return project;
    }
    private Project project;

    @Override
    public void create(Project obj) {

        this.project = project;
        //TODO sql insert schrijven
        String sql = "INSERT INTO project(name, created_at, done) VALUES (?,?,?);";

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.project.getName());
            statement.setTimestamp(2,this.project.getCreated_at());
            statement.setBoolean(3, this.project.getDone());


            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Project added");
    }

    @Override
    public void update(Project obj) {
        this.project = project;
        //TODO sql update schrijven
        String sql = "UPDATE project SET(naam=? ,invoice_id=?, contact_id=?, expense_id=?, quotation_id=?, created_at= ?, done =? ) WHERE invoice_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.project.getName());
            statement.setString(2,null);
            statement.setString(3,null);
            statement.setString(4,null);
            statement.setString(5,null);
            statement.setTimestamp(6,null);
            statement.setBoolean(7,false);

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Project Updated");

    }


    @Override
    public void delete(Project obj) {
        this.project = obj;
        //TODO sql delete schrijven
        String sql = "DELETE FROM project WHERE project_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.project.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Project deleted");
    }

    @Override
    public Project extractFromResultSet(ResultSet rs) throws SQLException {
        Project project = new Project(
                rs.getString("name"), rs.getString("done").toString()
        );


        project.setId(rs.getInt("id"));

        return project;
    }
}
