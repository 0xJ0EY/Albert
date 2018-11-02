package DAO;

import albert.controllers.ProjectsController;
import albert.controllers.templates.MenuTemplateController;
import albert.dao.ContactDAO;
import albert.models.Contact;
import albert.models.Project;
import albert.views.ProjectsView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import router.Route;
import router.Router;
import router.action.OverviewPageAction;
import router.factories.pages.home.HomePageFactory;
import router.response.Response;
import router.response.ViewResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApplicationExtension.class)
public class DAOTest {

    private ContactDAO Contactdao = new ContactDAO();
    private Project project;
    private Contact contact;

    @BeforeEach
    void setupEach() {
        this.router = new Router(null);
    }

    @Test
    void linkingTest(){
        Project project= new Project();
        this.contact = new Contact();
        contact.setFirstName("Xander");

        project.setContact(contact);
        Contact contact2= Contactdao.loadById(1);

        assertEquals(contact2.getFirstName(),this.contact.getFirstName());


    }



}
