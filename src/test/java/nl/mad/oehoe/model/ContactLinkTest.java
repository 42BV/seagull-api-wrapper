package nl.mad.oehoe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactLinkTest {

    @Test
    public void constructContactLink() {
        ContactLink contactLink = new ContactLink();
        contactLink.setContactLinkId(0);
        contactLink.setDetails("Details");
        contactLink.setFirstContactId(0);
        contactLink.setRelationshipId(0);
        contactLink.setSecondContactId(0);

        assertEquals("Id is not the same, ", 0, contactLink.getContactLinkId());
        assertEquals("Detail is not the same, ", "Details", contactLink.getDetails());
        assertEquals("Id is not the same, ", 0, contactLink.getFirstContactId());
        assertEquals("Id is not the same, ", 0, contactLink.getRelationshipId());
        assertEquals("Id is not the same, ", 0, contactLink.getSecondContactId());
    }

}
