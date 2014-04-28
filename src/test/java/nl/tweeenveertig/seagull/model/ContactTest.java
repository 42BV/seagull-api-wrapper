package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactTest {

    @Test
    public void constructContact() {

        Contact contact = new Contact();
        contact.setContactId(0);
        contact.setDefaultLinkedOrganisation(0);
        contact.setFirstName("First");
        contact.setLastName("Last");
        contact.setSalutation("Salutation");
        assertEquals("Id is not the same, ", 0, contact.getContactId());
        assertEquals("Default linked organisation is not the same, ", 0, contact.getDefaultLinkedOrganisation());
        assertEquals("Firstname is not the same, ", "First", contact.getFirstName());
        assertEquals("Lastname is not the same, ", "Last", contact.getLastName());
        assertEquals("Salutation is not the same, ", "Salutation", contact.getSalutation());

    }

}
