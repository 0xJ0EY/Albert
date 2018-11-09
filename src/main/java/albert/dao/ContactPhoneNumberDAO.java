package albert.dao;

import albert.models.Contact;
import albert.models.ContactPhoneNumber;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactPhoneNumberDAO.
 * @author
 */
public class ContactPhoneNumberDAO {

    /** The Constant NEW_PHONE_NUMBER_ID. */
    private static final int NEW_PHONE_NUMBER_ID = 0;

    /** The select query. */
    private final String SELECT_QUERY = "SELECT * FROM contact_phone WHERE contact_id = ?;";
    
    /** The insert query. */
    private final String INSERT_QUERY = "INSERT INTO contact_phone (phone_number, contact_id) VALUES (?, ?);";
    
    /** The update query. */
    private final String UPDATE_QUERY = "UPDATE contact_phone SET phone_number = ? WHERE id = ?;";
    
    /** The delete query. */
    private final String DELETE_QUERY = "DELETE FROM contact_phone WHERE id = ?;";

    /**
     * Load contact phone numbers.
     *
     * @param contact the contact
     * @return the array list
     */
    public ArrayList<ContactPhoneNumber> loadContactPhoneNumbers(Contact contact) {
        ArrayList<ContactPhoneNumber> phoneNumberSave = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(this.SELECT_QUERY);

            statement.setLong(1, contact.getId());

            ResultSet rs = statement.executeQuery();

            ContactPhoneNumber contactPhoneNumber;

            while (rs.next()) {
                contactPhoneNumber = new ContactPhoneNumber();

                contactPhoneNumber.setId(rs.getInt("id"));
                contactPhoneNumber.setPhoneNumber(rs.getString("phone_number"));
                contactPhoneNumber.setContact(contact);

                phoneNumberSave.add(contactPhoneNumber);
            }

            statement.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return phoneNumberSave;
    }


    /**
     * Update phone numbers.
     *
     * @param contact the contact
     */
    public void updatePhoneNumbers(Contact contact) {
        ArrayList<ContactPhoneNumber> newPhoneNumbers = contact.getPhoneNumbers();
        HashMap<Integer, ContactPhoneNumber> oldPhoneNumbers = new HashMap<>();

        for (ContactPhoneNumber number : this.loadContactPhoneNumbers(contact)) {
            number.setContact(contact);
            oldPhoneNumbers.put(number.getId(), number);
        }

        ArrayList<ContactPhoneNumber> insertNumbers = new ArrayList<>();
        ArrayList<ContactPhoneNumber> updateNumbers = new ArrayList<>();

        for (ContactPhoneNumber number : newPhoneNumbers) {

            // New numbers don't have an id yet, so just add them to the insert ArrayList
            if (number.getId() == NEW_PHONE_NUMBER_ID) {
                insertNumbers.add(number);
            }

            //
            if (oldPhoneNumbers.get(number.getId()) != null) {
                updateNumbers.add(number);
                oldPhoneNumbers.remove(number.getId());
            }

        }

        ArrayList<ContactPhoneNumber> deleteNumbers = new ArrayList<>(oldPhoneNumbers.values());

        // Insert phone numbers
        for (ContactPhoneNumber number : insertNumbers)
            this.insertPhoneNumber(number);

        // Update phone numbers
        for (ContactPhoneNumber number : updateNumbers)
            this.updatePhoneNumber(number);

        // Delete old phone numbers
        for (ContactPhoneNumber number : deleteNumbers)
            this.deletePhoneNumber(number);
    }

    /**
     * Insert phone number.
     *
     * @param phoneNumber the phone number
     */
    private void insertPhoneNumber(ContactPhoneNumber phoneNumber) {

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.INSERT_QUERY);

            int i = 0;

            statement.setString(++i, phoneNumber.getPhoneNumber());
            statement.setInt(++i, phoneNumber.getContact().getId());

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Update phone number.
     *
     * @param phoneNumber the phone number
     */
    private void updatePhoneNumber(ContactPhoneNumber phoneNumber) {

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.UPDATE_QUERY);

            int i = 0;

            statement.setString(++i, phoneNumber.getPhoneNumber());
            statement.setInt(++i, phoneNumber.getId());

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Delete phone number.
     *
     * @param phoneNumber the phone number
     */
    private void deletePhoneNumber(ContactPhoneNumber phoneNumber) {

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.DELETE_QUERY);

            int i = 0;

            statement.setInt(++i, phoneNumber.getId());

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}