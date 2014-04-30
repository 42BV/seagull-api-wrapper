package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactInfoTest {

    @Test
    public void constructContactInfo() {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setContactInfoId(0L);
        contactInfo.setDetail("Detail");
        contactInfo.setLabel("Label");
        contactInfo.setSubType("SubType");
        contactInfo.setType("Type");
        assertEquals("Id is not the same, ", new Long(0), contactInfo.getContactInfoId());
        assertEquals("Detail is not the same, ", "Detail", contactInfo.getDetail());
        assertEquals("Label is not the same, ", "Label", contactInfo.getLabel());
        assertEquals("SubType is not the same, ", "SubType", contactInfo.getSubType());
        assertEquals("Type is not the same, ", "Type", contactInfo.getType());
    }

}
