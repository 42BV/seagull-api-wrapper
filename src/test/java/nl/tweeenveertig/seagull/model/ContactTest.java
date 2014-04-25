package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ContactTest {

    @Test
    public void constructContact() {
        List<Address> addresses = new ArrayList<Address>();

        List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();

        List<CustomField> customFields = new ArrayList<CustomField>();

        List<Tag> tags = new ArrayList<Tag>();

        Contact contact = new Contact();
        contact.setAddresses(addresses);
        contact.setBackGround("Background");
        contact.setContactId(0);
        contact.setContactInfos(contactInfos);
        contact.setCustomFields(customFields);
        contact.setDateCreatedUtc("01-01-2011");
        contact.setDateUpdatedUtc("01-01-2011");
        contact.setDefaultLinkedOrganisation(0);
        contact.setFirstName("First");
        contact.setImageUrl("Image");
        contact.setLastName("Last");
        contact.setSalutation("Salutation");
        contact.setTags(tags);

        assertNotNull("Address should not be null, ", contact.getAddresses());
        assertEquals("Background is not the same, ", "Background", contact.getBackGround());
        assertEquals("Id is not the same, ", 0, contact.getContactId());
        assertNotNull("ContactInfo should not be null, ", contact.getContactInfos());
        assertNotNull("CustomField should not be null, ", contact.getCustomFields());
        assertEquals("Date created is not the same, ", "01-01-2011", contact.getDateCreatedUtc());
        assertEquals("Date updated is not the same, ", "01-01-2011", contact.getDateUpdatedUtc());
        assertEquals("Default linked organisation is not the same, ", 0, contact.getDefaultLinkedOrganisation());
        assertEquals("Firstname is not the same, ", "First", contact.getFirstName());
        assertEquals("ImageURL is not the same, ", "Image", contact.getImageUrl());
        assertEquals("Lastname is not the same, ", "Last", contact.getLastName());
        assertEquals("Salutation is not the same, ", "Salutation", contact.getSalutation());
        assertNotNull("Tag should not be null, ", contact.getTags());

    }

}
