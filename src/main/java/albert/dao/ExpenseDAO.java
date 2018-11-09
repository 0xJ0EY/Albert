package albert.dao;

import albert.models.Expense;
import albert.models.Invoice;
import albert.models.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import albert.models.Project;
import database.Database;

import java.sql.*;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class ExpenseDAO.
 * @author
 */
public class ExpenseDAO implements DAO<Expense>{

    /** The expense. */
    private Expense expense;
    
    /** The project DAO. */
    private ProjectDAO projectDAO = new ProjectDAO();

    /* (non-Javadoc)
     * @see albert.dao.DAO#getAll()
     */
    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM expense";
        ArrayList<Expense> expensesArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                this.expense = extractFromResultSet(rs);
                expensesArrayList.add(expense);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expensesArrayList;

    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#loadById(long)
     */
    @Override
    public Expense loadById(long id) {

        String sql = ("SELECT * FROM expense WHERE expense_id = ?");
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();

            expense = this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return expense;
    }




    /* (non-Javadoc)
     * @see albert.dao.DAO#create(java.lang.Object)
     */
    @Override
    public void create(Expense obj) {
        this.expense = obj;
        //TODO sql insert schrijven
        String sql = "INSERT INTO expense (price, created_at, description, name, project_id) VALUES (?, ? ,? ,? ,? );";

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1,this.expense.getPrice());
            statement.setTimestamp(2,this.expense.getCreated_at());
            statement.setString(3,this.expense.getDescription());
            statement.setString(4,this.expense.getName());
            statement.setInt(5,this.expense.getProject().getId());

            statement.execute();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Expense added");

    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#update(java.lang.Object)
     */
    @Override
    public void update(Expense obj) {

        this.expense = obj;
        //TODO sql update schrijven
        String sql = "UPDATE expense SET price =?, created_at =? , description =?, name=? WHERE expense_id=?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1,this.expense.getPrice());
            statement.setTimestamp(2,this.expense.getCreated_at());
            statement.setString(3,this.expense.getDescription());
            statement.setString(4,this.expense.getName());
            statement.setInt(5,this.expense.getId());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Expense Updated");
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#delete(java.lang.Object)
     */
    @Override
    public void delete(Expense obj) {
        this.expense = obj;


        String sql = "DELETE FROM expense WHERE contact_id = ?";

        try {

            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.expense.getId());

            statement.executeQuery();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("expense deleted");
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#extractFromResultSet(java.sql.ResultSet)
     */
    @Override
    public Expense extractFromResultSet(ResultSet rs) throws SQLException {

        Expense expense = new Expense(
                rs.getInt("expense_id"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getTimestamp("created_at"),
                rs.getString("name")
        );
        expense.setProject(projectDAO.loadById(rs.getInt("project_id")));

        return expense;
    }


}