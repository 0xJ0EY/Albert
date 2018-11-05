package albert.dao;

import albert.models.Contact;
import albert.models.Invoice;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactDAO implements DAO<Contact> {
    private Contact contact;
    private ProjectDAO projectDAO = new ProjectDAO();

    @Override
    public ArrayList getAll() {
        String sql = "SELECT * FROM contact";
        ArrayList<Contact> contactArrayList = null;
        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                this.contact = extractFromResultSet(rs);
                contactArrayList.add(contact);
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactArrayList;
    }

    @Override
    public Contact loadById(long id) {


        String sql = "SELECT * FROM contact WHERE contact_id = ?";

        try {
            Connection conn = Database.getInstance().getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();

            contact= this.extractFromResultSet(rs);


            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return contact;
    }


    @Override
    public void create(Contact contact) {

        this.contact= contact;

        //TODO sql insert schrijven
        String sql = "INSERT INTO contact(first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?); " +
                "UPDATE project SET contact_id=? WHERE project_id=?  ";

         try {

                Connection conn = Database.getInstance().getConnection();

                PreparedStatement statement = conn.prepareStatement(sql);
                int i=0;
                statement.setString(i++, this.contact.getFirstName());
                statement.setString(i++, this.contact.getLastName());
                statement.setString(i++, this.contact.getTelephoneNumber());
                statement.setString(i++, this.contact.getPostcode());
                statement.setString(i++, this.contact.getStraatnaam());
                statement.setString(i++, this.contact.getHouseNumber());
                statement.setString(i++, this.contact.getWoonplaats());
                statement.setTimestamp(i++, this.contact.getCreated_at());
                statement.setString(i++, this.contact.getWebsite());
                statement.setString(i++, this.contact.getBeschrijving());
                statement.setInt(i++,this.contact.getId());
                statement.setInt(i++, this.contact.getProject().getId());
               //TODO project later koppelenj niet bij create
                // statement.setInt(11, this.contact.getProject().getId());

                statement.executeQuery();
                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact added");
    }


    @Override
    public void update(Contact obj) {

        this.contact=obj;

        String sql = "UPDATE contact SET first_name=?,last_name=?,tel_number=?,postal_code=?,street_name=?,house_number=?,created_at=?,website=?,description=?" +
                " WHERE contact_id = ?;" +
                "UPDATE project SET contact_id=? WHERE project_id=?;";

        try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);

            int i=0;
            statement.setString(i++, this.contact.getFirstName());
            statement.setString(i++, this.contact.getLastName());
            statement.setString(i++, this.contact.getTelephoneNumber());
            statement.setString(i++, this.contact.getPostcode());
            statement.setString(i++, this.contact.getStraatnaam());
            statement.setString(i++, this.contact.getHouseNumber());
            statement.setString(i++, this.contact.getWoonplaats());
            statement.setTimestamp(i++, this.contact.getCreated_at());
            statement.setString(i++, this.contact.getWebsite());
            statement.setString(i++, this.contact.getBeschrijving());
            statement.setInt(i++,this.contact.getId());
            statement.setInt(i++, this.contact.getProject().getId());


                statement.executeQuery();

                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact updated");
    }

    @Override
    public  void delete(Contact contact) {
        this.contact = contact;


            String sql = "DELETE FROM contact WHERE contact_id = ?";

            try {

                Connection conn = Database.getInstance().getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, this.contact.getId());

                statement.executeQuery();

                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Contact deleted");
        }

    @Override
    public Contact extractFromResultSet(ResultSet rs) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getInt("contact_id"));
                contact.setFirstName(rs.getString("first_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setPostcode(rs.getString("postal_code"));
                contact.setWebsite(rs.getString("website"));
                contact.setBeschrijving(rs.getString("description"));
                contact.setStraatnaam(rs.getString("street_name"));
                contact.setHouseNumber(rs.getString("house_number"));
                contact.setWoonplaats(rs.getString("city"));
                contact.setCreated_at(rs.getTimestamp("created_at"));
                contact.setProject(projectDAO.loadById(rs.getInt("project_id")));

        return contact;
    }

}
