import java.util.List;

import nl.mad.http.Account;
import nl.mad.http.AccountCredentials;
import nl.mad.model.Contacts;

public final class Main {

    private Main() {

    }

    /**
     * This is only for testing purposes.
     * @param args
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Account account = new Account(new AccountCredentials("b1b4fe31-a5f3-4261-a6cf-3ef87cf02102"));

        Contacts contact = new Contacts();
        contact.setFirstName("Jan");
        contact.setLastName("Willem");

        //account.getCommandFactory().getContactsCommandFactory().createDeleteContactsCommand(54946439).call();

        //account.getCommandFactory().getContactsCommandFactory().createPostContactsCommand(contact).call();

        List<Contacts> contactList = account.getCommandFactory().getContactsCommandFactory().createGetContactsCommand().call();
        printList(contactList);

        //findContact(contactList, account);

        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }

    /**
     * Prints a list of contacts.
     * @param contactList
     */
    public static void printList(List<Contacts> contactList) {
        for (Contacts o : contactList) {
            System.out.println(o.toString());
        }
    }

    public static void findContact(List<Contacts> list, Account account) {
        for (Contacts cont : list) {
            if ("Jan".equals(cont.getFirstName())) {
                account.getCommandFactory().getContactsCommandFactory().createDeleteContactsCommand(cont.getContactId()).call();
                System.out.println("ACCOUNT GEVONDEN");
            }
        }
    }
}
