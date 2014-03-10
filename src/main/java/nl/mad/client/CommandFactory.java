package nl.mad.client;

import nl.mad.http.Account;
import nl.mad.http.command.base.factory.ContactsCommandFactory;
import nl.mad.http.command.impl.factory.ContactsCommandFactoryImpl;

public class CommandFactory {
    private Account account;

    public CommandFactory(Account account) {
        this.account = account;
    }

    public ContactsCommandFactory getContactsCommandFactory() {
        return new ContactsCommandFactoryImpl(account);
    }
}
