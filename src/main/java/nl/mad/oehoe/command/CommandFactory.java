package nl.mad.oehoe.command;

import nl.mad.oehoe.command.base.factory.ContactsCommandFactory;
import nl.mad.oehoe.command.impl.factory.ContactsCommandFactoryImpl;
import nl.mad.oehoe.model.Account;

/**
 * 
 * @author Ruben Zorgman
 */
public class CommandFactory {
    private Account account;

    /**
     * Creates an instance of CommandFactory.
     * @param account The account
     */
    public CommandFactory(Account account) {
        this.account = account;
    }

    public ContactsCommandFactory getContactsCommandFactory() {
        return new ContactsCommandFactoryImpl(account);
    }
}
