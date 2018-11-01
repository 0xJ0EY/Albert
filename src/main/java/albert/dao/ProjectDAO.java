package albert.dao;

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

        String sql = "SELECT * FROM projects";
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

        String sql = "SELECT * FROM projects WHERE id = ?";

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
        String sql = "INSERT INTO project VALUES (project_id=?, naam=? ,created_at= ?, afgerond=?);";



        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.project.getId());
            statement.setString(2,this.project.getName());
            statement.setTimestamp(3, null);
            statement.setBoolean(4,true);

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
        String sql = "UPDATE project SET naam=? ,created_at= ?, afgerond=? WHERE invoice_id =?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(4,this.project.getId());
            statement.setString(1,this.project.getName());
            statement.setTimestamp(2 ,null);
            statement.setBoolean(3, true);

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Project Updated");

    }


    @Override
    public void delete(Project obj) {
        this.project = project;
        //TODO sql delete schrijven
        String sql = "DELETE FROM project WHERE invoice_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.project.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("project deleted");
    }

    @Override
    public Project extractFromResultSet(ResultSet rs) throws SQLException {
        Project project = new Project(
                rs.getString("name"), rs.getString("done").toString()
        );
        //TODO add all columns

        project.setId(rs.getInt("id"));

        return project;
    }
}
