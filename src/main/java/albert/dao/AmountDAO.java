package albert.dao;
import albert.models.Amount;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Class AmountDAO. Insert an object into the database. And gets data from the database to an object.
 *
 */
public class AmountDAO implements DAO<Amount> {

    /** The amount. */
    private Amount amount;

    /** The dao contact. */
    private ContactDAO daoContact = new ContactDAO();
    
    /* (non-Javadoc)
     * @see albert.dao.DAO#getAll()
     */
    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM amount";
        ArrayList<Amount> AmountArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                this.amount =extractFromResultSet(rs);
                AmountArrayList.add(amount);
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AmountArrayList;
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#loadById(long)
     */
    @Override
    public Amount loadById(long id) {
        String sql = "SELECT * FROM amount WHERE amount_id = ?";

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next())
                amount = this.extractFromResultSet(rs);

            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return amount;
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#create(java.lang.Object)
     */
    @Override
    public void create(Amount obj) {

        this.amount= obj;
        //TODO sql insert schrijven
        String sql = "INSERT INTO amount(amount_id, hours, price, contact_id) VALUES (DEFAULT, ?,?,?);";

        try {
                Connection conn = Database.getInstance().getConnection();
                String generatedColumns[] = {"amount_id"};
                PreparedStatement statement = conn.prepareStatement(sql, generatedColumns);

                statement.setDouble(1,this.amount.getHours());
                statement.setDouble(2,this.amount.getPrice());
                statement.setInt(3,this.amount.getContact().getId());

                statement.execute();

                ResultSet rs = statement.getGeneratedKeys();

                if (rs.next())
                    obj.setId(rs.getInt("amount_id"));

                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Amount added");
    }

    /**
     * Gets the last inserted id.
     *
     * @return the last inserted id
     */
    public int getLastInsertedId() {
        return this.amount.getId();
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#update(java.lang.Object)
     */
    @Override
    public void update(Amount obj) {
        this.amount = obj;
        //TODO sql update schrijven
        String sql = "UPDATE amount SET hours=?, price =?, contact_id=?  WHERE amount_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1,this.amount.getHours());
            statement.setDouble(2,this.amount.getPrice());
            statement.setInt(3, this.amount.getContact().getId());
            statement.setInt(4, this.amount.getId());

            statement.executeQuery();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("amount Updated");

    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#delete(java.lang.Object)
     */
    @Override
    public void delete(Amount obj) {
        this.amount = obj;
        //TODO sql delete schrijven
        String sql = "DELETE FROM amount WHERE amount_id =?";
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1,this.amount.getId());

            statement.executeQuery();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Amount deleted");
    }

    /* (non-Javadoc)
     * @see albert.dao.DAO#extractFromResultSet(java.sql.ResultSet)
     */
    @Override
    public Amount extractFromResultSet(ResultSet rs) throws SQLException {
        Amount amount = new Amount();
        amount.setId(rs.getInt("amount_id"));
        amount.setPrice(rs.getDouble("price"));
        amount.setHours(rs.getDouble("hours"));
        amount.setContact(daoContact.loadById(rs.getInt("contact_id")));

        return amount;
    }
}
