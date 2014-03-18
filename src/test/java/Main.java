import java.util.List;

import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.AccountCredentials;
import nl.mad.oehoe.model.Contact;

public final class Main {

    private Main() {

    }

    /**
     * This is only for testing purposes.
     * @param args
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Account account = new Account(new AccountCredentials("b1b4fe31-a5f3-4261-a6cf-3ef87cf02102", "https://api.insight.ly/v2.1/"));

        Contact contact = new Contact();
        contact.setFirstName("Jan");
        contact.setLastName("Willem");

        //account.getContactsCommandFactory().createDeleteContactsCommand(54946439).call();

        //account.getContactsCommandFactory().createPostContactsCommand(contact).call();

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
}
