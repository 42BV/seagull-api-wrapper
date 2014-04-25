import java.util.List;

import nl.tweeenveertig.seagull.Insightly;
import nl.tweeenveertig.seagull.model.Organisation;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Insightly insightly = new Insightly(args[0]);

        //List<Contact> contactList = insightly.getContacts();
        List<Organisation> organisationList = insightly.getOrganisations();

        System.out.println("Number of contacts: " + organisationList.size());

        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }
}
