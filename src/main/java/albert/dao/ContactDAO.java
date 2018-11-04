package albert.dao;

import albert.models.Contact;
import albert.models.ContactEmail;
import albert.models.ContactPhoneNumber;
import database.Database;

import java.sql.*;
import java.util.ArrayList;

public class ContactDAO implements DAO<Contact> {

    private final ContactEmailDAO contactEmailDAO = new ContactEmailDAO();
    private final ContactPhoneNumberDAO contactPhoneNumberDAO = new ContactPhoneNumberDAO();

    private final String SELECT_CONTACT_SQL = "SELECT * FROM contact WHERE contact_id = ?";

    private final String CREATE_CONTACT_SQL = "INSERT INTO \"contact\" " +
            "(\"contact_id\", " +
            "\"first_name\", " +
            "\"last_name\", " +
            "\"postal_code\", " +
            "\"street_name\", " +
            "\"house_number\", " +
            "\"city\", " +
            "\"website\", " +
            "\"description\") " +
            "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String UPDATE_CONTACT_SQL = "UPDATE contact SET " +
            "first_name=?, " +
            "last_name=?, " +
            "postal_code=?, " +
            "street_name=?, " +
            "house_number=?, " +
            "city=?, " +
            "website=?, " +
            "description=? " +
            "WHERE " +
            "contact_id = ?";

    private final String DELETE_CONTACT_SQL = "DELETE FROM contact WHERE contact_id = ?";

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
            throw new RuntimeException(e);
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
            contact.setHouseNumber(rs.getString("house_number"));
            contact.setCity(rs.getString("city"));
            contact.setWebsite(rs.getString("website"));
            contact.setDescription(rs.getString("description"));
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

        try {
            Connection conn = Database.getInstance().getConnection();

            String generatedColumns[] = {"contact_id"};
            PreparedStatement statement = conn.prepareStatement(this.CREATE_CONTACT_SQL, generatedColumns);

            int i = 0;

            statement.setString(++i, contact.getFirstName());
            statement.setString(++i, contact.getLastName());
            statement.setString(++i, contact.getPostalCode());
            statement.setString(++i, contact.getStreetName());
            statement.setString(++i, contact.getHouseNumber());
            statement.setString(++i, contact.getStreetName());
            statement.setString(++i, contact.getWebsite());
            statement.setString(++i, contact.getDescription());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
                contact.setId(rs.getInt("contact_id"));

            this.contactEmailDAO.updateEmails(contact);
            this.contactPhoneNumberDAO.updatePhoneNumbers(contact);

            statement.close();
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public void update(Contact contact) {

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.UPDATE_CONTACT_SQL);

            int i = 0;

            statement.setString(++i, contact.getFirstName());
            statement.setString(++i, contact.getLastName());
            statement.setString(++i, contact.getPostalCode());
            statement.setString(++i, contact.getStreetName());
            statement.setString(++i, contact.getHouseNumber());
            statement.setString(++i, contact.getStreetName());
            statement.setString(++i, contact.getWebsite());
            statement.setString(++i, contact.getDescription());

            statement.setInt(++i, contact.getId());

            this.contactEmailDAO.updateEmails(contact);
            this.contactPhoneNumberDAO.updatePhoneNumbers(contact);

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public  void delete(Contact contact) {

        // Remove all old phone numbers
        contact.setPhoneNumbers(new ArrayList<>());
        contactPhoneNumberDAO.updatePhoneNumbers(contact);

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.DELETE_CONTACT_SQL);
            statement.setInt(1, contact.getId());

            statement.executeUpdate();

            // Delete phone numbers
            contact.setEmails(new ArrayList<>());
            contact.setPhoneNumbers(new ArrayList<>());

            this.contactEmailDAO.updateEmails(contact);
            this.contactPhoneNumberDAO.updatePhoneNumbers(contact);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Contact extractFromResultSet(ResultSet rs) throws SQLException {
        return this.loadById(rs.getInt("contact_id"));
    }

}
