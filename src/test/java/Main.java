import java.util.List;

import nl.tweeenveertig.seagull.Insightly;
import nl.tweeenveertig.seagull.model.Contact;
import nl.tweeenveertig.seagull.model.Link;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Insightly insightly = new Insightly(args[0]);

        List<Contact> contactList = insightly.getContacts();

        System.out.println("Number of contacts: " + contactList.size());
        for (Contact c : contactList) {
            for (Link l : c.getLinks()) {
                System.out.println(l.getContactId());
                System.out.println(l.getOrganisationId());
            }
        }

        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }
}
