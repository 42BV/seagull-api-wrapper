package nl.mad.client;

import java.util.List;

import nl.mad.http.Account;
import nl.mad.http.AccountCredentials;
import nl.mad.model.Contacts;

public final class Client {

    private Client() {

    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Account account = new Account(new AccountCredentials("https://api.insight.ly/v2.1/", "b1b4fe31-a5f3-4261-a6cf-3ef87cf02102"));

        Contacts contact = new Contacts();
        contact.setFirstName("Brim");
        contact.setLastName("Bamboo");

        account.getCommandFactory().getContactsCommandFactory().createPostContactsCommand(contact).call();
        List<Contacts> contactList = account.getCommandFactory().getContactsCommandFactory().createGetContactsCommand().call();

        //account.getCommandFactory().getContactsCommandFactory().createDeleteContactsCommand(54664608).call();
        printList(contactList);
        //findContact(contactList, account);
        long stop = System.currentTimeMillis();
        System.out.println("Time it took: " + (stop - start));
    }

    public static void printList(List<Contacts> contactList) {
        for (Contacts o : contactList) {
            System.out.println(o.toString());
        }
    }

    public static void findContact(List<Contacts> list, Account account) {
        for (Contacts cont : list) {
            if ("Henkert".equals(cont.getFirstName())) {
                cont.setFirstName("Ali");
                System.out.println("ACCOUNT GEVONDEN");
                account.getCommandFactory().getContactsCommandFactory().createPutContactsCommand(cont).call();
            }
        }
    }
}
