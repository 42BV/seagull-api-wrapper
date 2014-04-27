import java.util.List;

import nl.tweeenveertig.seagull.Insightly;
import nl.tweeenveertig.seagull.model.Contact;
import nl.tweeenveertig.seagull.model.Organisation;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Insightly insightly = new Insightly(args[0]);

        List<Contact> contactList = insightly.getContacts();
        List<Organisation> organisationList = insightly.getOrganisations();

        //        Organisation organisation = new Organisation();
        //        organisation.setOrganisationName("Ruben's ding jo");
        //        insightly.createOrganisation(organisation);

        System.out.println("Number of Organisations: " + organisationList.size());
        System.out.println("Number of contacts: " + contactList.size());

        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }
}
