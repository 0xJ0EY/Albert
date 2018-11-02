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

public class ContactPhoneNumberDAO {

    private final String SELECT_QUERY = "SELECT * FROM contact_phone WHERE contact_id = ?;";
    private final String INSERT_QUERY = "INSERT INTO contact_phone (phone_number, contact_id) VALUES (?, ?);";
    private final String UPDATE_QUERY = "UPDATE contact_phone SET phone_number = ? WHERE phone_id = ?;";
    private final String DELETE_QUERY = "DELETE contact_phone WHERE phone_id = ?";

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

                contactPhoneNumber.setId(rs.getInt("phone_id"));
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


    public void updatePhoneNumbers(Contact contact) {
        ArrayList<ContactPhoneNumber> oldPhoneNumbers = this.loadContactPhoneNumbers(contact);
        Set<Integer> oldNumbers = new HashSet<>();

        for (ContactPhoneNumber contactPhone : oldPhoneNumbers) {
            oldNumbers.add(contactPhone.getId());

        }

        ArrayList<ContactPhoneNumber> newPhoneNumbers = contact.getPhoneNumbers();


        ArrayList<ContactPhoneNumber> insertNumbers = new ArrayList<>();
        ArrayList<ContactPhoneNumber> updateNumbers = new ArrayList<>();

        for (ContactPhoneNumber number : newPhoneNumbers) {

//            if (number.getId() == 0) {
//                insertNumbers.add(number);
//                continue;
//            }
//
//            if ()


        }

//        ArrayList<ContactPhoneNumber> updateNumbers=  new ArrayList<>();
//        ArrayList<Integer>








    }

    private void insertPhoneNumber(ContactPhoneNumber phoneNumber) {

    }


    private void updatePhoneNumber(ContactPhoneNumber phoneNumber) {

    }

    private void deletePhoneNumber(int phoneNumberId) {


    }

}
