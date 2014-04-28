package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AbstractEntityTest {

    @Test
    public void constructAbstractEntity() {

        List<Address> addresses = new ArrayList<Address>();
        List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();
        List<CustomField> customFields = new ArrayList<CustomField>();
        List<Tag> tags = new ArrayList<Tag>();
        List<Link> links = new ArrayList<Link>();

        AbstractEntity abstractEntity = new AbstractEntity();
        abstractEntity.setAddresses(addresses);
        abstractEntity.setContactInfos(contactInfos);
        abstractEntity.setCustomFields(customFields);
        abstractEntity.setTags(tags);
        abstractEntity.setLinks(links);
        abstractEntity.setDateCreatedUtc("01-01-2011");
        abstractEntity.setDateUpdatedUtc("01-01-2011");
        abstractEntity.setBackGround("Background");

        assertNotNull("Address should not be null, ", abstractEntity.getAddresses());
        assertEquals("Background is not the same, ", "Background", abstractEntity.getBackGround());
        assertNotNull("ContactInfo should not be null, ", abstractEntity.getContactInfos());
        assertNotNull("CustomField should not be null, ", abstractEntity.getCustomFields());
        assertEquals("Date created is not the same, ", "01-01-2011", abstractEntity.getDateCreatedUtc());
        assertEquals("Date updated is not the same, ", "01-01-2011", abstractEntity.getDateUpdatedUtc());
        assertNotNull("Tag should not be null, ", abstractEntity.getTags());
        assertNotNull("Link should not be null, ", abstractEntity.getLinks());

    }

}
