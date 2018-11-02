package albert.dao;

import albert.models.Contact;
import albert.models.ContactEmail;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactEmailDAO {

    private final String SELECT_QUERY = "SELECT * FROM contact_email WHERE contact_id = ?";

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

                contactEmail.setId(rs.getInt("email_id"));
                contactEmail.setEmailAddress(rs.getString("email_address"));
                contactEmail.setContact(contact);

                emails.add(contactEmail);
            }

            statement.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return emails;
    }

}
