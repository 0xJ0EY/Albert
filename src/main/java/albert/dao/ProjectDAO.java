package albert.dao;

import albert.models.Project;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProjectDAO implements DAO<Project> {

    private Project project;


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

            project = this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return project;
    }


    @Override
    public void create(Project project) {

        this.project = project;
        //TODO sql insert schrijven
//        String sql = "INSERT INTO project(name, created_at, done, contact_id) VALUES (?,?,?,?);";
        String sql = "INSERT INTO project(name, created_at, done) VALUES (?,?,?);";

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,this.project.getName());
            statement.setTimestamp(2,this.project.getCreated_at());
            statement.setBoolean(3, this.project.getDone());
 //           statement.setInt(4,this.project.getContactId().getId());


            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Project added");
    }

    @Override
    public void update(Project project) {
        this.project = project;
        //TODO sql update schrijven
        String sql = "UPDATE project SET(naam=? ,invoice_id=?, contact_id=?, expense_id=?, quotation_id=?, created_at= ?, done =? ) WHERE project_id =?";
//        String sql = "UPDATE project SET(naam=?, done =? ) WHERE project_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

//            statement.setString(1,this.project.getName());
//            statement.setBoolean(2,this.project.getDone());
//            statement.setInt(3, this.project.getId());

            statement.setString(1,this.project.getName());
            statement.setInt(2,this.project.getInvoiceId());
            statement.setInt(3,this.project.getContactId());
            statement.setInt(4,this.project.getExpenseId());
            statement.setInt(5,this.project.getQuotationId());
            statement.setTimestamp(6,this.project.getCreated_at());
            statement.setBoolean(7,this.project.getDone());
            statement.setInt(8, this.project.getId());

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

        project.setId(rs.getInt("project_id"));
        project.setExpenseId(rs.getInt("expense_id"));
        project.setQuotationId(rs.getInt("quotation_id"));
        project.setInvoiceId(rs.getInt("invoice_id"));
        project.setContactId(rs.getInt("contact_id"));
        project.setCreated_at(rs.getTimestamp("created_at"));

        return project;
    }
}
