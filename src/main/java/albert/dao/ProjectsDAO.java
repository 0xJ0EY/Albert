package albert.dao;

import albert.models.Project;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
Deze klas implementeert de interface DAO.
 */
public class ProjectsDAO implements DAO<Project> {

    @Override
    public ArrayList<Project> getAll() {
        return null;
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

            project = new Project(
                rs.getInt("id"),
                rs.getString("name")
            );

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
}
