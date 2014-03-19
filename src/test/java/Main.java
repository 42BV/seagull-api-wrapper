import java.util.ArrayList;
import java.util.List;

import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.AccountCredentials;
import nl.mad.oehoe.model.Address;
import nl.mad.oehoe.model.Contact;
import nl.mad.oehoe.model.ContactInfo;
import nl.mad.oehoe.model.ContactLink;
import nl.mad.oehoe.model.Tag;

public final class Main {

    private Main() {

    }

    /**
     * This is only for testing purposes.
     * @param args
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Account account = new Account(new AccountCredentials(args[0], "https://api.insight.ly/v2.1/"));

        //account.getContactsCommandFactory().createDeleteContactsCommand(54946439).call();

        //account.getContactsCommandFactory().createPostContactsCommand(createContact()).call();

        List<Contact> contactList = account.getContactsCommandFactory().createGetContactsCommand().call();
        printList(contactList);

        //findContact(contactList, account);

        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }

    /**
     * Prints a list of contacts.
     * @param contactList
     */
    public static void printList(List<Contact> contactList) {
        for (Contact o : contactList) {
            System.out.println(o.toString());
        }
    }

    public static void findContact(List<Contact> list, Account account) {
        for (Contact cont : list) {
            if ("Jan".equals(cont.getFirstName())) {
                account.getContactsCommandFactory().createDeleteContactsCommand(cont.getContactId()).call();
                System.out.println("ACCOUNT GEVONDEN");
            }
        }
    }

    private static Contact createContact() {
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setAddressType("Werk");
        address.setCity("Test");
        address.setCountry("Test");
        address.setPostcode("Test");
        address.setState("Test");
        address.setStreet("Test");
        addresses.add(address);

        List<ContactInfo> contactInfos = new ArrayList<ContactInfo>();
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setDetail("Test");
        contactInfo.setLabel("Test");
        contactInfo.setSubType("Test");
        contactInfo.setType("Test");
        contactInfos.add(contactInfo);

        List<ContactLink> contactLinks = new ArrayList<ContactLink>();
        ContactLink contactLink = new ContactLink();
        contactLink.setDetails("Test");
        contactLink.setFirstContactId(0);
        contactLink.setRelationshipId(0);
        contactLink.setSecondContactId(0);
        contactLinks.add(contactLink);

        List<Tag> tags = new ArrayList<Tag>();
        Tag tag = new Tag();
        tag.setTagName("Test");
        tags.add(tag);

        Contact contact = new Contact();
        contact.setAddresses(addresses);
        contact.setBackGround("test");
        contact.setContactInfos(contactInfos);
        contact.setContactLinks(contactLinks);

        contact.setDefaultLinkedOrganisation(0);
        contact.setFirstName("Test");
        contact.setImageUrl("Test");
        contact.setLastName("Test");
        contact.setSalutation("Test");
        contact.setTags(tags);

        return contact;
    }
}
