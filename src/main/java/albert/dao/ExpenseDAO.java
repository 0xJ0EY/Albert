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


public class ExpenseDAO implements DAO<Expense>{

    private Expense expense;
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

    @Override
    public Expense loadById(long id) {
        Expense expense = null;

        String sql = ("SELECT * FROM expense WHERE expense_id = ?");
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

        return expense;
    }




    @Override
    public void create(Expense obj) {
        this.expense = expense;
        //TODO sql insert schrijven
        String sql = "INSERT INTO expense VALUES (expense_id=?, prijs =?, created_at =? , description =?, naam=?);";

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.expense.getId());
            statement.setDouble(2,this.expense.getPrice());
            statement.setTime(3,(Time) this.expense.getCreated_at());
            statement.setString(4,this.expense.getDescription());
            statement.setString(5,this.expense.getName());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Expense added");

    }

    @Override
    public void update(Expense obj) {

        this.expense = obj;
        //TODO sql update schrijven
        String sql = "UPDATE expense SET( prijs =?, created_at =? , description =?, naam=?) WHERE expense_id=?)";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1,this.expense.getPrice());
            statement.setTime(2,(Time) this.expense.getCreated_at());
            statement.setString(3,this.expense.getDescription());
            statement.setString(4,this.expense.getName());

            statement.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Expense Updated");
    }

    @Override
    public void delete(Expense obj) {
        this.expense = obj;


        String sql = "DELETE FROM expense WHERE contact_id = ?";

        try {

            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.expense.getId());

            statement.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("expendse deleted");

    }

    @Override
    public Expense extractFromResultSet(ResultSet rs) throws SQLException {

        Expense expense = new Expense(
                rs.getDouble("price"),
        rs.getString("description"),
        rs.getTimestamp("created_at"),
        rs.getString("name")
        );
        return expense;
    }


}
