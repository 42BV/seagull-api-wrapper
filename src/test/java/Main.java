import java.util.ArrayList;
import java.util.List;

import nl.tweeenveertig.seagull.Insightly;
import nl.tweeenveertig.seagull.model.Address;
import nl.tweeenveertig.seagull.model.Contact;
import nl.tweeenveertig.seagull.model.ContactInfo;
import nl.tweeenveertig.seagull.model.CustomField;
import nl.tweeenveertig.seagull.model.Organisation;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Insightly insightly = new Insightly(args[0]);
        //Organisation organisation = createOrganisation();
        //organisation.setAddresses(createAddresses());
        //organisation.setContactInfos(createContactInfo());
        //organisation.setCustomFields(createCustomField());
        //organisation.setBackGround("Robert's stage bedrijf");
        //organisation.setOrganisationName("Blumen Riviera");
        //organisation.setOrganisationId(29647786);
        //insightly.updateOrganisation(organisation);

        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }

    public static List<Address> createAddresses() {
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setAddressType("Work");
        address.setCity("Zoetermeer");
        address.setCountry("Nederland");
        address.setPostcode("26514ZZ");
        address.setStreet("Plantsoen 99");
        addresses.add(address);
        return addresses;

    }

    public static List<CustomField> createCustomField() {
        List<CustomField> customFields = new ArrayList<CustomField>();
        CustomField customField = new CustomField();
        customField.setCustomFieldId("ORGANISATION_FIELD_1");
        customField.setFieldValue("25");
        customFields.add(customField);
        return customFields;
    }

    public static List<ContactInfo> createContactInfo() {
        List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setDetail("064565478");
        contactInfo.setLabel("Work");
        contactInfo.setType("Phone");
        contactInfos.add(contactInfo);
        ContactInfo contactInfoN = new ContactInfo();
        contactInfoN.setDetail("test@test.com");
        contactInfoN.setLabel("Work");
        contactInfoN.setType("Email");
        contactInfos.add(contactInfoN);
        return contactInfos;
    }

    public static Organisation createOrganisation() {
        Organisation organisation = new Organisation();
        organisation.setOrganisationName("Ruben's nieuwe bedrijf");
        return organisation;
    }

    public static Contact createContact() {
        Contact contact = new Contact();
        contact.setFirstName("Klaas");
        contact.setLastName("de Vries");
        return contact;
    }

    public static void getInfo(Insightly insightly) {
        List<Contact> contactList = insightly.getContacts();
        List<Organisation> organisationList = insightly.getOrganisations();

        System.out.println("Number of Organisations: " + organisationList.size());
        System.out.println("Number of contacts: " + contactList.size());
    }
}
