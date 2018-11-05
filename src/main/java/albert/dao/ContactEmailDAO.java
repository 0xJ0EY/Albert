package albert.dao;

import albert.models.ContactEmail;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactEmailDAO implements DAO<ContactEmail> {
    private ContactEmail contactEmail;
    private ContactDAO contactDAO= new ContactDAO();

    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM contactEmail";
        ArrayList<ContactEmail> contactArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                this.contactEmail = extractFromResultSet(rs);
                contactArrayList.add(contactEmail);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactArrayList;
    }

    @Override
    public ContactEmail loadById(long id) {
        ContactEmail contactEmail = null;

        String sql = "SELECT * FROM contactEmail WHERE contact_id = ?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();

            this.contactEmail= this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return this.contactEmail;
    }


    @Override
    public void create(ContactEmail contact) {

        this.contactEmail = contact;

        //TODO sql insert schrijven
        String sql = "INSERT INTO contact_email(contact_id, email_address)" +
                "VALUES (?,?,?);";

         try {

                Connection conn = Database.getInstance().getConnection();

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1,this.contactEmail.getContact().getId());
                statement.setString(2, this.contactEmail.getEmailAddress());


                statement.executeQuery();
                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact added");
    }


    @Override
    public void update(ContactEmail obj) {

        this.contactEmail =obj;

        String sql = "UPDATE contactEmail SET contact_id=?, email_address=?  WHERE email_id = ?";

        try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1,this.contactEmail.getContact().getId());
                statement.setString(2, this.contactEmail.getEmailAddress());
                statement.setInt(3, this.contactEmail.getId());


                statement.executeUpdate();

                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact updated");
    }

    @Override
    public  void delete(ContactEmail contactEmail) {
        this.contactEmail = contactEmail;


            String sql = "DELETE FROM contactEmail WHERE contact_id = ?";

            try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, this.contactEmail.getId());

                statement.executeUpdate();

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Contact deleted");
        }

    @Override
    public ContactEmail extractFromResultSet(ResultSet rs) throws SQLException {
        ContactEmail contactEmail = new ContactEmail();
        contactEmail.setId(rs.getInt("email_id"));
        contactEmail.setContact(contactDAO.loadById(rs.getInt("contact_id")));
        contactEmail.setEmailAddress("email_address");


        return contactEmail;
    }

}
