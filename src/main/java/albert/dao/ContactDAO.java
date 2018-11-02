package albert.dao;

import albert.models.Contact;
import albert.models.ContactEmail;
import albert.models.ContactPhoneNumber;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactDAO implements DAO<Contact> {


    private final ContactEmailDAO contactEmailDAO = new ContactEmailDAO();
    private final ContactPhoneNumberDAO contactPhoneNumberDAO = new ContactPhoneNumberDAO();

    private final String SELECT_CONTACT_SQL = "SELECT * FROM contact WHERE contact_id = ?";

    @Override
    public ArrayList<Contact> getAll() {
        String sql = "SELECT contact_id FROM contact";

        ArrayList<Contact> contactArrayList = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                contactArrayList.add(this.extractFromResultSet(rs));
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactArrayList;
    }

    @Override
    public Contact loadById(long id) {
        Contact contact = new Contact();

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(this.SELECT_CONTACT_SQL);

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();

            contact.setId(rs.getInt("contact_id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setPostalCode(rs.getString("postal_code"));
            contact.setStreetName(rs.getString("street_name"));
            contact.setCity(rs.getString("city"));
            contact.setCreated_at(rs.getTimestamp("created_at"));

            contact.setEmails(this.contactEmailDAO.loadContactEmails(contact));
            contact.setPhoneNumbers(this.contactPhoneNumberDAO.loadContactPhoneNumbers(contact));

            statement.close();
            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return contact;
    }

    @Override
    public void create(Contact contact) {

        //TODO sql insert schrijven
        String sql = "INSERT INTO contact(first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?);";

         try {
                Connection conn = Database.getInstance().getConnection();

                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, contact.getFirstName());
                statement.setString(2, contact.getLastName());
                statement.setString(3, contact.getPostalCode());
                statement.setString(4, contact.getStreetName());
                statement.setString(5, contact.getHouseNumber());
                statement.setString(6, contact.getCity());
                statement.setTimestamp(7, contact.getCreated_at());
                statement.setString(8, contact.getWebsite());
                statement.setString(9, contact.getDescription());
               //TODO project later koppelenj niet bij create
                // statement.setInt(11, this.contact.getProject().getId());


                statement.executeQuery();
                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Contact contact) {

        String sql = "UPDATE contact SET first_name=?,last_name=?,tel_number=?,postal_code=?,street_name=?,house_number=?,created_at=?,website=?,description=? WHERE contact_id = ?";

        try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);

                statement.setString(1, contact.getFirstName());
                statement.setString(2, contact.getLastName());
                statement.setString(3, contact.getPostalCode());
                statement.setString(4, contact.getStreetName());
                statement.setString(5, contact.getHouseNumber());

                statement.executeUpdate();

                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  void delete(Contact contact) {

            String sql = "DELETE FROM contact WHERE contact_id = ?";

            try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, contact.getId());

                statement.executeUpdate();

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public Contact extractFromResultSet(ResultSet rs) throws SQLException {
        return this.loadById(rs.getInt("contact_id"));
    }

}
