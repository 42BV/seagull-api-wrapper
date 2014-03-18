package nl.mad.oehoe.command;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.mad.oehoe.model.Address;
import nl.mad.oehoe.model.Contact;
import nl.mad.oehoe.model.ContactInfo;
import nl.mad.oehoe.model.ContactLink;
import nl.mad.oehoe.model.CustomField;
import nl.mad.oehoe.model.Tag;

import org.junit.Before;
import org.junit.Test;

//@formatter:off

public class PostContactsCommandImplTest extends BaseCommandTest {

    @Before
    public void setup() throws IOException {
        super.setup();
    }
    


    @Test
    public void PostContactTest() {
        Contact contact = createContact();        
        setStatusLineCode(201);
        account.getContactsCommandFactory().createPostContactsCommand(contact).call();
    }
    
    private Contact createContact(){
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setAddressId(0);
        address.setAddressType("Werk");
        address.setCity("Test");
        address.setCountry("Test");
        address.setPostcode("Test");
        address.setState("Test");
        address.setStreet("Test");
        address.toString();
        addresses.add(address);
        
        List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setContactInfoId(0);
        contactInfo.setDetail("Test");
        contactInfo.setLabel("Test");
        contactInfo.setSubType("Test");
        contactInfo.setType("Test");
        contactInfo.toString();
        contactInfos.add(contactInfo);
        
        List<ContactLink> contactLinks = new ArrayList<ContactLink>();
        ContactLink contactLink = new ContactLink();
        contactLink.setContactLinkId(0);
        contactLink.setDetails("Test");
        contactLink.setFirstContactId(0);
        contactLink.setRelationshipId(0);
        contactLink.setSecondContactId(0);
        contactLink.toString();
        contactLinks.add(contactLink);
        
        List<CustomField> customFields = new ArrayList<CustomField>();
        CustomField customField = new CustomField();
        customField.setCustomFieldId("Test");
        customField.setFieldValue("Test");
        customField.toString();
        customFields.add(customField);
        
        List<Tag> tags = new ArrayList<Tag>();
        Tag tag = new Tag();
        tag.setTagName("Test");
        tag.toString();
        tags.add(tag);        
        
        Contact contact = new Contact();
        contact.setAddresses(addresses);
        contact.setBackGround("test");
        contact.setContactId(0);
        contact.setContactInfos(contactInfos);
        contact.setContactLinks(contactLinks);
        contact.setCustomFields(customFields);
        contact.setDateCreatedUtc("01-01-2011");
        contact.setDateUpdatedUtc("01-01-2011");
        contact.setDefaultLinkedOrganisation(0);
        contact.setFirstName("Test");
        contact.setImageUrl("Test");
        contact.setLastName("Test");
        contact.setSalutation("Test");
        contact.setTags(tags);
        contact.toString();
        
        assertNotNull("Address should not be null, ", address);
        assertNotNull("ContactInfo should not be null, ", contactInfo);
        assertNotNull("ContactLink should not be null, ", contactLink);
        assertNotNull("CustomField should not be null, ", customField);
        assertNotNull("Tag should not be null, ", tag);
        assertNotNull("Contact should not be null, ", contact);
        
        return contact;        
    }

}
