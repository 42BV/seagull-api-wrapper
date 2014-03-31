import java.util.List;

import nl.tweeenveertig.seagull.Insightly;
import nl.tweeenveertig.seagull.model.Contact;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Contact contact = new Contact();
        //contact.setFirstName("Jan");
        //contact.setLastName("tenk");
        //contact.setContactId(52272486);

        Insightly insightly = new Insightly(args[0], "https://api.insight.ly/v2.1/");
        //insightly.createContact(contact);

        List<Contact> contactList = insightly.getContacts();
        System.out.println("Number of contacts: " + contactList.size());

        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }
}
