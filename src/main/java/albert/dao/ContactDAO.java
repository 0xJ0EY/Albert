package albert.dao;

import albert.models.Contact;
import albert.models.Project;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactDAO implements DAO {
    private Contact contact;

    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM customer";
        ArrayList<Contact> contactArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                this.contact = (Contact)extractFromResultSet(rs);
                contactArrayList.add(contact);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactArrayList;
    }

    @Override
    public Object loadById(long id) {
        Contact contact = null;

        String sql = "SELECT * FROM customer WHERE id = ?";

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

        return contact;
    }


    @Override
    public void create(Object contact) {
        this.contact= (Contact)contact;
        //TODO sql insert schrijven
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?);";



        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.contact.getId());
            statement.setString(2,this.contact.getFirstName());
            statement.setString(3,this.contact.getLastName());
            statement.setString(4,this.contact.getTelephoneNumber());
            statement.setString(5,this.contact.getEmail());
            statement.setString(6,this.contact.getPostcode());
            statement.setString(7,this.contact.getStraatnaam());
            statement.setString(8,this.contact.getHouseNumber());

            statement.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact added");
    }

    public void update(Object o, String[] params) {

    }

    @Override
    public void update(Object obj) {

        this.contact=contact;

        String sql = "UPDATE customer SET f_name=? , l_name=?, tel_number =?, email_address =?, postal_code=? , street_name =?,house_nr =? WHERE customer_id = ?";



        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,this.contact.getFirstName());
            statement.setString(2,this.contact.getLastName());
            statement.setString(3,this.contact.getTelephoneNumber());
            statement.setString(4,this.contact.getEmail());
            statement.setString(5,this.contact.getPostcode());
            statement.setString(6,this.contact.getStraatnaam());
            statement.setString(7,this.contact.getHouseNumber());
            statement.executeUpdate();


            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact updated");
    }

    @Override
    public  void delete(Object contact) {
        this.contact = (Contact) contact;


            String sql = "DELETE FROM customer WHERE id = ?";

            try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, this.contact.getId());

                statement.executeUpdate();

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Contact deleted");
        }

    @Override
    public Object extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
