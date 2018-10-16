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

    @Override
    public void create(Project obj) {

    }

    @Override
    public void update(Project obj) {

    }


    @Override
    public void delete(Project obj) {

    }

    @Override
    public Project extractFromResultSet(ResultSet rs) throws SQLException {
        Project project = new Project(rs.getInt("id"), rs.getString("name"));
        //TODO add all columns

        return project;
    }
}
