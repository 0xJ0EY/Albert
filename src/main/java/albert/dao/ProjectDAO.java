package albert.dao;

import albert.models.Contact;
import albert.models.Project;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class ProjectDAO.
 * @author
 */
public class ProjectDAO implements DAO<Project> {

    /** The contact DAO. */
    private ContactDAO contactDAO = new ContactDAO();

    /* (non-Javadoc)
     * @see albert.dao.DAO#getAll()
     */
    @Override
    public ArrayList<Project> getAll() {

        String sql = "SELECT * FROM project";
        ArrayList<Project> projectArrayList = new ArrayList<Project>();
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Project newProject = extractFromResultSet(rs);
                projectArrayList.add(newProject);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectArrayList;
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#loadById(long)
     */
    @Override
    public Project loadById(long id) {
        Project project = null;

        String sql = "SELECT * FROM project WHERE project_id = ?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next())
                project = this.extractFromResultSet(rs);

            statement.close();
            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return project;
    }


    /* (non-Javadoc)
     * @see albert.dao.DAO#create(java.lang.Object)
     */
    @Override
    public void create(Project project) {

        String sql = "INSERT INTO project(name, description, contact_id, done) VALUES (?, ?,?,?);";

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            int i = 0;
            statement.setString(++i, project.getName());
            statement.setString(++i, project.getDescription());
            statement.setInt(++i, project.getContact().getId());
            statement.setBoolean(++i, project.getDone());

            statement.execute();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#update(java.lang.Object)
     */
    @Override
    public void update(Project project) {
        String sql = "UPDATE project SET name=?, description=?, contact_id=?, done =?  WHERE project_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            int i = 0;
            statement.setString(++i, project.getName());
            statement.setString(++i, project.getDescription());
            statement.setInt(++i, project.getContact().getId());
            statement.setBoolean(++i, project.getDone());
            statement.setInt(++i, project.getId());

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#delete(java.lang.Object)
     */
    @Override
    public void delete(Project obj) {
        //TODO sql delete schrijven
        String sql = "DELETE FROM project WHERE project_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, obj.getId());

            statement.execute();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Project deleted");
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#extractFromResultSet(java.sql.ResultSet)
     */
    @Override
    public Project extractFromResultSet(ResultSet rs) throws SQLException {

        Project project = new Project();

        project.setId(rs.getInt("project_id"));
        project.setName(rs.getString("name"));
        project.setDone(rs.getBoolean("done"));
        project.setDescription(rs.getString("description"));
        project.setContact(contactDAO.loadById(rs.getInt("contact_id")));

        project.setCreated_at(rs.getTimestamp("created_at"));

        return project;
    }
}