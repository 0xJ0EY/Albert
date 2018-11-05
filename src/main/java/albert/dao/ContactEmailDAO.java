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
import java.util.HashMap;

public class ContactEmailDAO {

    private static final int NEW_EMAIL_ID = 0;

    private final String SELECT_QUERY = "SELECT * FROM contact_email WHERE contact_id = ?;";
    private final String INSERT_QUERY = "INSERT INTO contact_email (email_address, contact_id) VALUES (?, ?);";
    private final String UPDATE_QUERY = "UPDATE contact_email SET email_address = ? WHERE id = ?;";
    private final String DELETE_QUERY = "DELETE FROM contact_email WHERE id = ?;";

    public ArrayList<ContactEmail> loadContactEmails(Contact contact) {
        ArrayList<ContactEmail> emails = new ArrayList<>();

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(this.SELECT_QUERY);

            statement.setLong(1, contact.getId());

            ResultSet rs = statement.executeQuery();

            ContactEmail contactEmail;

            while (rs.next()) {
                contactEmail = new ContactEmail();

                contactEmail.setId(rs.getInt("id"));
                contactEmail.setEmailAddress(rs.getString("email_address"));
                contactEmail.setContact(contact);

                emails.add(contactEmail);
            }

            statement.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println("emails size = " + emails.size());

        return emails;
    }

    public void updateEmails(Contact contact) {
        ArrayList<ContactEmail> newEmails = contact.getEmails();
        HashMap<Integer, ContactEmail> oldEmails = new HashMap<>();

        for (ContactEmail email : this.loadContactEmails(contact)) {
            email.setContact(contact);
            oldEmails.put(email.getId(), email);
        }

        ArrayList<ContactEmail> insert = new ArrayList<>();
        ArrayList<ContactEmail> update = new ArrayList<>();

        for (ContactEmail email : newEmails) {

            email.setContact(contact);

            // New numbers don't have an id yet, so just add them to the insert ArrayList
            if (email.getId() == NEW_EMAIL_ID) {
                insert.add(email);
            }

            // If
            if (oldEmails.get(email.getId()) != null) {
                update.add(email);
                oldEmails.remove(email.getId());
            }
        }

        ArrayList<ContactEmail> delete = new ArrayList<>(oldEmails.values());

        // Insert phone numbers
        for (ContactEmail email : insert)
            this.insertEmail(email);

        // Update phone numbers
        for (ContactEmail email : update)
            this.updateEmail(email);

        // Delete old phone numbers
        for (ContactEmail email : delete)
            this.deleteEmail(email);

    }

    private void insertEmail(ContactEmail email) {

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.INSERT_QUERY);

            int i = 0;

            statement.setString(++i, email.getEmailAddress());
            statement.setInt(++i, email.getContact().getId());

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void updateEmail(ContactEmail email) {

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.UPDATE_QUERY);

            int i = 0;

            statement.setString(++i, email.getEmailAddress());
            statement.setInt(++i, email.getId());

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void deleteEmail(ContactEmail email) {

        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement(this.DELETE_QUERY);

            statement.setInt(1, email.getId());

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
